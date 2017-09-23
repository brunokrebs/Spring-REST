package com.userapi.restcontroller;

import com.userapi.entity.ApplicationUser;
import com.userapi.jpa.ApplicationUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

    private ApplicationUserRepository applicationUserRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private SignUpController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder){

        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationUser> signUpUserForApplication(@RequestBody ApplicationUser applicationUser){
        logger.info(applicationUser.toString());
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        applicationUserRepository.save(applicationUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
