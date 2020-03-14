package com.simonblund.rest.webservices.incidentapi.model.incident;

import com.simonblund.rest.webservices.incidentapi.model.entity.PhoneNumber;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncidentMsg {

    private String message;
    private LocalDateTime timestamp;
    private PhoneNumber phoneNumber;
}
