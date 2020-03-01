package com.simonblund.rest.webservices.incidentapi.dao;

import com.simonblund.rest.webservices.incidentapi.exception.IncidentNotFoundException;
import com.simonblund.rest.webservices.incidentapi.model.Incident;
import com.simonblund.rest.webservices.incidentapi.service.IncidentService;
import com.simonblund.rest.webservices.incidentapi.service.serviceImpl.IncidentServiceImpl;
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

    public List<Incident> findAll(){
        return incidents;
    }

    public UUID save(Incident incident){
        //System.out.println(incident.getMessage());
        incident.setUuid(service.uuid());
        incidents.add(incident);
        return incident.getUuid();
    }

    public Incident findOne(UUID uuid){
        Incident found = incidents.stream().filter(incident -> uuid.equals(incident.getUuid())).findAny().get();
        if(found.getMessage().isEmpty()){
            throw new IncidentNotFoundException("findOne by UUID failed");
        }
        return found;
    }
}
