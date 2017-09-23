package com.userapi.security;

import com.userapi.entity.ApplicationUser;
import com.userapi.jpa.ApplicationUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    private Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private UserDetailServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUserName = applicationUserRepository.findByUsername(username);
        logger.info(applicationUserName.getUsername() + applicationUserName.getPassword());
        if (applicationUserName == null) {
            throw new UsernameNotFoundException("username not found");
        }
        return new User(applicationUserName.getUsername(), applicationUserName.getPassword(), emptyList());
    }
}
