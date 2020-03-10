package com.simonblund.rest.webservices.incidentapi.domain.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class LogPost {
    private String message;
    private UUID uuid;
    private LocalDateTime timestamp;
    //@TODO add user from userservice.

}
