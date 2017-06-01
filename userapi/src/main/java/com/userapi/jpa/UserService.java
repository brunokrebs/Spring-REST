package com.userapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userapi.entity.User;

@Transactional
@Service
public interface UserService extends JpaRepository<User, Integer> {

}
