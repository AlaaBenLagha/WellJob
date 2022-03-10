package com.pidev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.BlockList;
import com.pidev.repository.BlockListRepo;

@Service
public class BlockServiceImpl{
    @Autowired
    private BlockListRepo blockListRepo;
    
    
    
    public void addUserToBlockList(BlockList blockList) {
            blockListRepo.save(blockList);
    }
}
