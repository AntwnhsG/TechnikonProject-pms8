package com.example.technikonproject.controller;

import com.example.technikonproject.base.BaseComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws")
@RequiredArgsConstructor
public class WSocketController extends BaseComponent {

    private final SimpMessagingTemplate messagingTemplate;

    @SendTo("/topic/notifications")
    @MessageMapping("/login")
    public String sendNotification( String username){

        return username + " has logged in";
    }

}