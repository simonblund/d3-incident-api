package com.simonblund.rest.webservices.incidentapi.model;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Incident {

    @Size(min = 2)
    private final String message;
    private UUID uuid;
    private Date time;

    private String address;
    private String area;
    private String latPos;
    private String lonPos;

    private Enum type;
    private String details;


    protected boolean canEqual(final Object other) {
        return other instanceof Incident;
    }

}
