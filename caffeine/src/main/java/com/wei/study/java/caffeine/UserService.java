package com.wei.study.java.caffeine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Cacheable(value = "user", key = "#id")
    public User getUser(Integer id) {
        User user = new User(id, "李四");
        log.info(user.toString());
        return user;
    }
}
