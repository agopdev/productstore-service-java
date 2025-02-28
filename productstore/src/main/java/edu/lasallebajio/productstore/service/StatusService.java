package edu.lasallebajio.productstore.service;

import edu.lasallebajio.productstore.model.Status;
import edu.lasallebajio.productstore.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(Long id) {
        return statusRepository.findById(id);
    }

    public Optional<Status> getStatusByName(String name) {
        return statusRepository.findByName(name);
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }
    
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
