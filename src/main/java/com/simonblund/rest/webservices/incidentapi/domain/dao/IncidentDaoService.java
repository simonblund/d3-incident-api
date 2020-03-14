package com.simonblund.rest.webservices.incidentapi.domain.dao;

import com.simonblund.rest.webservices.incidentapi.model.incident.Incident;

import java.util.List;
import java.util.UUID;

public interface IncidentDaoService {
    UUID create(Incident incident);
    Incident findOne(UUID uuid);
    List<Incident> getAll();


}
