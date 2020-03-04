package com.simonblund.rest.webservices.incidentapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Incident {

    @Size(min = 2)
    @ApiModelProperty(notes = "Should be the raw textmsg from IncidentCenter")
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
