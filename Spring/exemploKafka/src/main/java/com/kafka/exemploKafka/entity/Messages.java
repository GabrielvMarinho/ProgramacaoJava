package com.kafka.exemploKafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Messages {
    @Id
    Integer id;
    String message;
}
