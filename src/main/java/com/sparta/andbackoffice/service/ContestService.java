package com.sparta.andbackoffice.service;
import com.sparta.andbackoffice.entity.Contest;
import com.sparta.andbackoffice.repository.ContestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "ContestService")
@RequiredArgsConstructor
public class ContestService {

    private ContestRepository contestRepository;


}
