package com.pidev.repository;

import com.pidev.models.BlockList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockListRepo extends JpaRepository<BlockList,Long> {
}
