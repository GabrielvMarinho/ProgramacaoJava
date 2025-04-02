package com.kafka.exemploKafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "lasteste", groupId = "1")
    public void ouvir(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}