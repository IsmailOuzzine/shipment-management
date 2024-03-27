package admin.controller;

import admin.model.Agency;
import admin.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    // Endpoint to retrieve all agencies
    @GetMapping
    public ResponseEntity<List<Agency>> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    // Endpoint to retrieve an agency by ID
    @GetMapping("/{id}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable long id) {
        return agencyService.getAgencyById(id);
    }

    // Endpoint to create a new agency
    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
        return agencyService.createAgency(agency);
    }

    // Endpoint to update an existing agency
    @PutMapping("/{id}")
    public ResponseEntity<Agency> updateAgency(@PathVariable long id, @RequestBody Agency agency) {
        return agencyService.updateAgency(id, agency);
    }

    // Endpoint to delete an agency
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable long id) {
        return agencyService.deleteAgency(id);
    }
}

