package com.example.eurekanotification.controller;


import com.example.eurekanotification.entities.Notification;
import com.example.eurekanotification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/public/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable long id){
         return notificationService.getNotification(id);
    }

    @PutMapping("/{id}")
    public Notification editNotification(@PathVariable long id, @RequestBody Notification notification){
        return  notificationService.updateNotification(id,notification);
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        return  notificationService.saveNotification(notification);
    }

    @DeleteMapping("/{id}")
    public  String removeNotification(@PathVariable long id){
        return  notificationService.deleteNotification(id);
    }
}
