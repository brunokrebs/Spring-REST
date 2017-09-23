package com.userapi.jpa;

import com.userapi.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

    ApplicationUser findByUsername(String username);

}
