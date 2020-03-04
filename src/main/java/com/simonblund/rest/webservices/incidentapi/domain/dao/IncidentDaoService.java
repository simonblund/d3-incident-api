package com.simonblund.rest.webservices.incidentapi.domain.dao;

import com.simonblund.rest.webservices.incidentapi.exception.IncidentNotFoundException;
import com.simonblund.rest.webservices.incidentapi.domain.model.Incident;
import com.simonblund.rest.webservices.incidentapi.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class IncidentDaoService {
    private static List<Incident> incidents = new ArrayList<>();

    @Autowired
    private static IncidentService service;

    public void initIncidents() {
        save(new Incident("2.6 Grundlarm - Automatalarm,LILLSKOGEN (2222),Ålandsvägen 23,010-MARIEHAMN"));
        save(new Incident("2.6 Grundlarm - Automatalarm,MELLANSKOGEN (1234),Ålandsvägen 23,010-MARIEHAMN"));
        save(new Incident("2.6 Grundlarm - Automatalarm,STORKOGEN (2222),Ålandsvägen 23,010-MARIEHAMN"));
    }

    public List<Incident> getAll(){
        return incidents;
    }

    public UUID save(Incident incident){
        //TODO Remove this infolog
        System.out.println("Incident created msg: "+incident.getMessage());
        incident.setUuid(UUID.randomUUID());
        incidents.add(incident);
        return incident.getUuid();
    }

    public Incident findOne(UUID uuid){
        Incident response = incidents.stream().filter(incident -> uuid.equals(incident.getUuid())).findAny().get();
        if(response.getMessage().isEmpty()){
            throw new IncidentNotFoundException("Nothing found");
        }
        return response;
    }
}
