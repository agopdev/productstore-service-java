package edu.lasallebajio.productstore.controller;

import edu.lasallebajio.productstore.model.Status;
import edu.lasallebajio.productstore.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Status> getStatusById(@PathVariable Long id) {
        return statusRepository.findById(id);
    }

    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusRepository.save(status);
    }

    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable Long id, @RequestBody Status status) {
        status.setId(id);
        return statusRepository.save(status);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusRepository.deleteById(id);
    }
}
