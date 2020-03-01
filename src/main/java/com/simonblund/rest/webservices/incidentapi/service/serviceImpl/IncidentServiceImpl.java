package com.simonblund.rest.webservices.incidentapi.service.serviceImpl;

import com.simonblund.rest.webservices.incidentapi.service.IncidentService;

import java.util.UUID;

public class IncidentServiceImpl implements IncidentService {


    @Override
    public UUID uuid(){
        return UUID.randomUUID();
    }

}
