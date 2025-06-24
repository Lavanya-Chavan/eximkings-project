package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // ✅ Add a new client
    @PostMapping("/add")
    public String addClient(@RequestBody Client client) {
        Integer maxIdNumber = clientRepository.findMaxClientIdNumber();
        int nextIdNumber = (maxIdNumber == null) ? 1 : maxIdNumber + 1;
        String newClientId = "CL" + nextIdNumber;
        client.setClientId(newClientId);

        clientRepository.save(client);
        return "Client added successfully with ID: " + newClientId;
    }

    // ✅ Get all clients (returns full client objects)
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // ✅ Get a single client by ID (returns 404 if not found)
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Update an existing client
    @PutMapping("/update")
    public String updateClient(@RequestBody Client updatedClient) {
        Optional<Client> optionalClient = clientRepository.findById(updatedClient.getClientId());

        if (optionalClient.isPresent()) {
            Client existing = optionalClient.get();

            // Update all fields
            existing.setCompanyName(updatedClient.getCompanyName());
            existing.setContactFirstName(updatedClient.getContactFirstName());
            existing.setContactLastName(updatedClient.getContactLastName());
            existing.setCountryCode(updatedClient.getCountryCode());
            existing.setContactNumber(updatedClient.getContactNumber());
            existing.setEmail(updatedClient.getEmail());
            existing.setClientType(updatedClient.getClientType());
            existing.setAddress(updatedClient.getAddress());
            existing.setCity(updatedClient.getCity());
            existing.setState(updatedClient.getState());
            existing.setCountry(updatedClient.getCountry());
            existing.setZipCode(updatedClient.getZipCode());
            existing.setGstNumber(updatedClient.getGstNumber());
            existing.setRequirementType(updatedClient.getRequirementType());
            existing.setBagLength(updatedClient.getBagLength());
            existing.setBagWidth(updatedClient.getBagWidth());
            existing.setBagHeight(updatedClient.getBagHeight());
            existing.setQuantity(updatedClient.getQuantity());
            existing.setNotes(updatedClient.getNotes());

            clientRepository.save(existing);
            return "Client updated successfully.";
        } else {
            return "Client not found with ID: " + updatedClient.getClientId();
        }
    }

    // ✅ Delete client by ID
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") String id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "Client deleted successfully with ID: " + id;
        } else {
            return "Client not found with ID: " + id;
        }
    }
}
