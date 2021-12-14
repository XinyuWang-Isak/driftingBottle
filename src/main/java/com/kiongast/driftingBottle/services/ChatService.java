package com.kiongast.driftingBottle.services;

import com.kiongast.driftingBottle.repos.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private AppUserRepository appUserRepository;

    public String hello(){
        return "Count: "+appUserRepository.count();
    }

    @Autowired
    public void setAppUserRepository(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

}
