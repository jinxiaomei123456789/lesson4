package com.jin.lesson4demo1.mapper;

import com.jin.lesson4demo1.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User,Integer> {
}
