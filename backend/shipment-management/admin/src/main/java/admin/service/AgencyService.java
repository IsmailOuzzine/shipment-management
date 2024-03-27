package admin.service;

import admin.exception.ResourceNotFoundException;
import admin.model.Agency;
import admin.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> agencies = agencyRepository.findAll();
        return new ResponseEntity<>(agencies, HttpStatus.OK);
    }

    public ResponseEntity<Agency> getAgencyById(Long id) {
        return agencyRepository.findById(id)
                .map(agency -> new ResponseEntity<>(agency, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with id: " + id));
    }

    public ResponseEntity<Agency> createAgency(Agency agency) {
        Agency createdAgency = agencyRepository.save(agency);
        return new ResponseEntity<>(createdAgency, HttpStatus.CREATED);
    }

    public ResponseEntity<Agency> updateAgency(Long id, Agency agency) {
        if (!agencyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agency not found with id: " + id);
        }
        agency.setId(id);
        Agency updatedAgency = agencyRepository.save(agency);
        return new ResponseEntity<>(updatedAgency, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteAgency(Long id) {
        if (!agencyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agency not found with id: " + id);
        }
        agencyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
