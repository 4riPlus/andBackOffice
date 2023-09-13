package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
