package com.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Notification;



@Repository
public interface NotificationRepository  extends CrudRepository<Notification,Long> {

}
