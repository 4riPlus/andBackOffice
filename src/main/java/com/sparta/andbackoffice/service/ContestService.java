package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.ContestRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.ContestResponseDto;
import com.sparta.andbackoffice.entity.Contest;
import com.sparta.andbackoffice.entity.ContestStatus;
import com.sparta.andbackoffice.repository.AdminRepository;
import com.sparta.andbackoffice.repository.ContestRepository;
import com.sparta.andbackoffice.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Slf4j(topic = "ContestService")
@RequiredArgsConstructor
public class ContestService {

	private final ContestRepository contestRepository;
	private final AdminRepository adminRepository;

	public ContestResponseDto createContest(ContestRequestDto requestDto, UserDetailsImpl userDetails) {
		log.info("Service - createContest : 시작");

		checkAdmin(userDetails);

		Contest contest = contestRepository.save(new Contest(requestDto));

		log.info("Service - createContest : 끝");
		return new ContestResponseDto(contest);
	}

	public ContestResponseDto getContest(Long contestId, UserDetailsImpl userDetails) {
		log.info("Service - getContest : 시작");

		checkAdmin(userDetails);
		Contest contest = findContest(contestId);

		log.info("Service - getContest : 끝");
		return new ContestResponseDto(contest);
	}

	@Transactional
	public ContestResponseDto modifyContest(Long contestId, ContestRequestDto requestDto, UserDetailsImpl userDetails) {
		log.info("Service - modifyContest : 시작");

		checkAdmin(userDetails);
		Contest contest = findContest(contestId);

		// Dto -> List 받아서 반복문 돌리게 하고 싶지만...
		contest.setAuthor(requestDto.getAuthor());
		contest.setTitle(requestDto.getTitle());
		contest.setCompany(requestDto.getCompany());
		contest.setEndDate(requestDto.getEndDate());
		contest.setStartDate(requestDto.getStartDate());
		contest.setHomepage(requestDto.getHomepage());
		contest.setContents(requestDto.getContents());

		log.info("Service - modifyContest : 끝");
		return new ContestResponseDto(contest);
	}

	@Transactional
	public ApiResponseDto deleteContest(Long contestId, UserDetailsImpl userDetails) {
		log.info("Service - deleteContest : 시작");

		checkAdmin(userDetails);
		Contest contest = findContest(contestId);
		contestRepository.delete(contest);

		log.info("Service - deleteContest : 끝");
		return new ApiResponseDto("게시글 삭제 완료", HttpStatus.OK.value());
	}

	public void checkAdmin(UserDetailsImpl userDetails) {
		adminRepository.findByAdminName(userDetails.getUser().getAdminName())
				.orElseThrow(
						() -> new NullPointerException("권한이 없습니다.")
				);
	}

	public Contest findContest(Long contestId) {
		return contestRepository.findById(contestId).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 글입니다.")
		);
	}

//	public ContestStatus contestStatus(Contest contest) {
//		LocalDate currentDate = LocalDate.now();
//
//		if (currentDate.isBefore(contest.getStartDate())) {
//			return ContestStatus.UPCOMING;
//		} else if (currentDate.isEqual(contest.getStartDate()) || currentDate.isEqual(contest.getEndDate()) || currentDate.isBefore(contest.getEndDate())) {
//			return ContestStatus.ONGOING;
//		} else if (currentDate.isBefore(contest.getEndDate().minusDays(3))) {
//			return ContestStatus.CLOSING;
//		} else {
//			return ContestStatus.CLOSED;
//		}
//	}
}
