package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.Client;
import com.bratyshevTD.carservicespringwebapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) { return clientRepository.getReferenceById(id);}

    public void addClient(Client client) { clientRepository.save(client); }

    public void deleteClientById(Long id) { clientRepository.deleteById(id); }

    public List<Client> find(String search) {return clientRepository.find(search); }

    public List<Client> filter(Long clientID, String fullName, String phone ) { return clientRepository.filter(clientID, fullName, phone); }
}
