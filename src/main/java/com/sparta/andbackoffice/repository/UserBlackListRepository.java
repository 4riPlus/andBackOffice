package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.User;
import com.sparta.andbackoffice.entity.UserBlackList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBlackListRepository extends JpaRepository<UserBlackList, Long> {


}
