package com.pidev.repository;

import com.pidev.models.Ask;
import com.pidev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AskRepo extends JpaRepository<Ask,Long> {

        List<Ask> findByUser(User user);
        int countAllByUser(User user);
        void deleteAllByUser(User user);
        void deleteById(Long id);
        



//        @Query(value ="delete user_id from questions where user__id=:UER_ID" ,nativeQuery = true)
//        void deleteUserFromQuestons(@Param("UER_ID") Long id );
}
