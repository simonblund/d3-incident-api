package com.simonblund.rest.webservices.incidentapi.controller;

import com.simonblund.rest.webservices.incidentapi.domain.dao.IncidentDaoService;
import com.simonblund.rest.webservices.incidentapi.domain.model.Incident;
import com.simonblund.rest.webservices.incidentapi.domain.model.IncidentMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class IncidentController {
    @Autowired
    private IncidentDaoService service;

    @GetMapping(path = "/incidents")
    public List<Incident> getAll(){
        service.initIncidents();
        return service.getAll();
    }

    @PostMapping(path = "/incidents")
    public ResponseEntity<Object> saveIncident(@RequestBody IncidentMsg incidentMsg){

        Incident inc = mapIncidentMessage(incidentMsg);
        UUID savedIncident = service.save(inc);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{savedIncident}")
                .buildAndExpand(savedIncident)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/incidents/{uuid}")
    public Incident getIncindet(@PathVariable UUID uuid){
        return service.findOne(uuid);
    }

    @PostMapping(path="/incidents/{uuid}")
    public  ResponseEntity<Incident> updateIncident(@PathVariable UUID uuid){
        // TODO check out swagger.
        Incident incident = service.findOne(uuid);
        UUID incidentUuid = incident.getUuid();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{incidentUuid}")
                .buildAndExpand(incident)
                .toUri();
        return ResponseEntity.created(location).build();

    }

    protected Incident mapIncidentMessage(IncidentMsg incidentMsg){
        Incident incident = new Incident(incidentMsg.getMessage());
        return incident;
    }



}
