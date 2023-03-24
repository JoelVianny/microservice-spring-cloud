package com.example.eurekanotification.service;

import com.example.eurekanotification.entities.Notification;
import com.example.eurekanotification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;

    public Notification getNotification(long id){
        return  notificationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
    }

    public  Notification saveNotification(Notification notifications){
        log.info(notifications.toString());
        Notification createNotification = notificationRepository.save(notifications);
        log.info(createNotification.toString());
        return  createNotification;
    }

    public Notification updateNotification(long id,Notification notification){

        log.info(notification.toString());
        Notification foundNotification = getNotification(id);
                    foundNotification.setHeader(notification.getHeader());
                    foundNotification.setDate(notification.getDate());
                    foundNotification.setText(notification.getText());
                    log.info(foundNotification.toString());
              return  notificationRepository.save(foundNotification);
    }

    public  String deleteNotification(long id){
        notificationRepository.delete(getNotification(id));
        return  "Notification  deleted";
    }

}
