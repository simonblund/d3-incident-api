package com.simonblund.rest.webservices.incidentapi.service;

import com.simonblund.rest.webservices.incidentapi.domain.model.Incident;

import java.util.UUID;

public interface IncidentService {
    UUID create(Incident incident);
}
