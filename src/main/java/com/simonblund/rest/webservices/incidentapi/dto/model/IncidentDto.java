package com.simonblund.rest.webservices.incidentapi.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.simonblund.rest.webservices.incidentapi.model.incident.IncidentMsg;
import com.simonblund.rest.webservices.incidentapi.model.incident.IncidentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.core.log.LogMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidentDto {
    private long id;
    private IncidentMsg message; // Should be DTO
    private LocalDateTime dateTime_started;
    private LocalDateTime dateTime_ended;

    private IncidentType type;
    private String details;
    private ArrayList<LogMessage> logMessages;
}

