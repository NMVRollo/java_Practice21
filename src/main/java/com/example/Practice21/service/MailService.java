package com.example.Practice21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender sender;
    @Value("${email.address}")
    private String emailAddress; //Обязательно поменять в application.yml

    @Async
    public void sendMessage() { //Вызвать этот метод там, где это нужно
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailAddress);
        message.setTo(""); //Куда отправлять
        message.setSubject(""); //Тема сообщения
        message.setText(""); //Текст сообщения
        sender.send(message);
    }

}
