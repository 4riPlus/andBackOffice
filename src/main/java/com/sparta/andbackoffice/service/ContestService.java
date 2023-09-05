package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.ContestRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.ContestResponseDto;
import com.sparta.andbackoffice.entity.Contest;
import com.sparta.andbackoffice.entity.ContestStatus;
import com.sparta.andbackoffice.repository.ContestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@EnableScheduling
@Slf4j(topic = "ContestService")
@RequiredArgsConstructor
public class ContestService {

	private final ContestRepository contestRepository;

	public ContestResponseDto createContest(ContestRequestDto requestDto) {
		log.info("Service - createContest : 시작");

		Contest contest = new Contest(requestDto);
		contest.setStatus((contestStatus(contest))); // 마감기한 코드 넣기
		contest = contestRepository.save(contest);

		log.info("Service - createContest : 끝");
		return new ContestResponseDto(contest);
	}

	public ContestResponseDto getContest(Long contestId) {
		log.info("Service - getContest : 시작");

		Contest contest = findContest(contestId);

		log.info("Service - getContest : 끝");
		return new ContestResponseDto(contest);
	}

	@Transactional
	public ContestResponseDto modifyContest(Long contestId, ContestRequestDto requestDto) {
		log.info("Service - modifyContest : 시작");

		Contest contest = findContest(contestId);

		// Dto -> List 받아서 반복문 돌리게 하고 싶지만...
		contest.setAuthor(requestDto.getAuthor());
		contest.setTitle(requestDto.getTitle());
		contest.setCompany(requestDto.getCompany());
		contest.setEndDate(requestDto.getEndDate());
		contest.setStartDate(requestDto.getStartDate());
		contest.setHomepage(requestDto.getHomepage());
		contest.setContents(requestDto.getContents());

		contest.setStatus(contestStatus(contest)); //마감기한 상태코드 다시 계산해서 업데이트

		log.info("Service - modifyContest : 끝");
		return new ContestResponseDto(contest);
	}

	@Transactional
	public ApiResponseDto deleteContest(Long contestId) {
		log.info("Service - deleteContest : 시작");

		Contest contest = findContest(contestId);
		contestRepository.delete(contest);

		log.info("Service - deleteContest : 끝");
		return new ApiResponseDto("게시글 삭제 완료", HttpStatus.OK.value());
	}

	public Contest findContest(Long contestId) {
		return contestRepository.findById(contestId).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 글입니다.")
		);
	}

	@Scheduled(cron = "0 0 0 * * ?") //매일 자정에 실행됨
	public void updateContestStatus(){
		log.info("Service - updateStatus : 시작");

		contestRepository.findAll() //모든 공보전을 가져오고
				.forEach(contest -> {  // 반복 루프 ContestStatus메서드 호출해서 상태코드 설정
					ContestStatus status = contestStatus(contest);
					contest.setStatus(status); //contest 객체에 set
				});

		log.info("Service - updateStatus : 끝");
	}

	public ContestStatus contestStatus(Contest contest) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime startDate = contest.getStartDate();
		LocalDateTime endDate = contest.getEndDate();
		LocalDateTime endDateMinus3Days = endDate.minusDays(3);

		if (currentDateTime.isBefore(startDate)) {
			return ContestStatus.UPCOMING;
		} else if (currentDateTime.isEqual(startDate) || currentDateTime.isEqual(endDate) || currentDateTime.isBefore(endDate)) {
			return ContestStatus.ONGOING;
		} else if (currentDateTime.isBefore(endDateMinus3Days)) {
			return ContestStatus.CLOSING;
		} else {
			return ContestStatus.CLOSED;
		}
	}
}
