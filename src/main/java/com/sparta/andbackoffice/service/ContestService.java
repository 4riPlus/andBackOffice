package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.entity.Contest;
import com.sparta.andbackoffice.entity.ContestStatus;
import com.sparta.andbackoffice.repository.ContestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j(topic = "ContestService")
@RequiredArgsConstructor
public class ContestService {

    private ContestRepository contestRepository;

    public ContestStatus contestStatus(Contest contest) {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isBefore(contest.getStartDate())) {
            return ContestStatus.UPCOMING;
        } else if (currentDate.isEqual(contest.getStartDate()) || currentDate.isEqual(contest.getEndDate()) || currentDate.isBefore(contest.getEndDate())) {
            return ContestStatus.ONGOING;
        } else if (currentDate.isBefore(contest.getEndDate().minusDays(3))) {
            return ContestStatus.CLOSING;
        } else {
            return ContestStatus.CLOSED;
        }
    }
}
