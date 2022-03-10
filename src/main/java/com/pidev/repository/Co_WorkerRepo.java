package com.pidev.repository;

import com.pidev.models.Co_Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Co_WorkerRepo extends JpaRepository<Co_Worker,Long> {
    List<Object> findByUser(Object user);
}
