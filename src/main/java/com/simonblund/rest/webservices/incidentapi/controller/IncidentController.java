package com.simonblund.rest.webservices.incidentapi.controller;

import com.simonblund.rest.webservices.incidentapi.dao.IncidentDaoService;
import com.simonblund.rest.webservices.incidentapi.model.Incident;
import com.simonblund.rest.webservices.incidentapi.model.IncidentMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class IncidentController {
    @Autowired
    private IncidentDaoService service;

    @GetMapping(path = "/incidents")
    public List<Incident> findAll(){
        service.initIncidents();
        return service.findAll();
    }

    @GetMapping(path="/incidents/{uuid}")
    public Incident findOne(@PathVariable UUID uuid){
        return service.findOne(uuid);
    }

    @PostMapping(path = "/incidents")
    public ResponseEntity<Object> saveIncident(@RequestBody IncidentMsg incidentMsg){
        /* TODO
        * Look in to how requestbody does this, why can't I pass a
        * Incident object with only the message through the post body even
        * though message is the only parameter in the Incident constructor*/
        //Incident incident = new Incident(message);
        //
        Incident inc = mapIncidentMessage(incidentMsg);
        UUID savedIncident = service.save(inc);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{uuid}")
                .buildAndExpand(savedIncident)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    protected Incident mapIncidentMessage(IncidentMsg incidentMsg){
        Incident incident = new Incident(incidentMsg.getMessage());
        return incident;
    }



}
