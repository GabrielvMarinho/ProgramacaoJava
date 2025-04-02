package com.kafka.exemploKafka.repository;

import com.kafka.exemploKafka.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {
}
