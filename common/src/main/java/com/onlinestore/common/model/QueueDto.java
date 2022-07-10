package com.onlinestore.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueueDto implements Serializable {
    private String messageId;
    private String message;
    private Instant createdAt;

    public QueueDto(String message) {
        messageId = UUID.randomUUID().toString();
        createdAt = Instant.now();
        this.message = message;
    }
}
