package com.pidev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.Co_WorkerRepo;
import com.pidev.serviceInterface.ICo_WorkerService;

import java.util.List;

@Service
public class Co_WorkerServiceImpl implements ICo_WorkerService {

    @Autowired
    private Co_WorkerRepo co_WorkerRepo;


    @Override
    public List<Object> getUserCo_Worker(Object user) {
        return co_WorkerRepo.findByUser(user);
    }
}
