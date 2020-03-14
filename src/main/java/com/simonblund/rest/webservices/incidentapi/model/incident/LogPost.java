package com.simonblund.rest.webservices.incidentapi.model.incident;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class LogPost {
    private String message;
    private UUID uuid;
    private LocalDateTime timestamp;
    //@TODO add user from userservice.

}
