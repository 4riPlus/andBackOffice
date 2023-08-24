package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.UserBlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBlackListRepository extends JpaRepository<UserBlackList, Long> {
}
