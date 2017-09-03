package com.userapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.userapi.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
