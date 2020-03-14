package com.simonblund.rest.webservices.incidentapi.model.incident;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "position")
public class Position {

    private String address;
    private String area;
    private String latPos;
    private String lonPos;

}
