package com.simonblund.rest.webservices.incidentapi.model.incident;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.core.log.LogMessage;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "incident")
public class Incident {

    @Id
    private long id;
    private IncidentMsg message;
    private LocalDateTime dateTime_started;
    private LocalDateTime dateTime_ended;


    private IncidentType type;
    private String details;

    @DBRef(lazy = true)
    private ArrayList<LogMessage> logMessages;


    protected boolean canEqual(final Object other) {
        return other instanceof Incident;
    }

}
