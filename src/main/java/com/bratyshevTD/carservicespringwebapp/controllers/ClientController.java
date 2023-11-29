package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.*;
import com.bratyshevTD.carservicespringwebapp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public String clientPage(Model model) {
        List<Client> client = clientService.getAllClients();
        model.addAttribute("clients", client);
        return "client";
    }

    @PostMapping("/client/add")
    public String addClient(@RequestParam(required = false) Long clientID, @RequestParam String fullName, @RequestParam String phone) {
        Client client = new Client(clientID, fullName, phone);
        clientService.addClient(client);
        return "redirect:/client";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClientById(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
        return "redirect:/client";
    }

    @GetMapping("/client/adds")
    public String addRandomClients() throws Exception {
        for (int i = 0; i < 1000; i++) {

            Client client = new Client();
            client.setClientID(null);
            client.setRandomFullName(new File("testData/fullName/surnames.txt"), new File("testData/fullName/names.txt"), new File("testData/fullName/patronymic.txt"));
            client.setRandomPhone();
            clientService.addClient(client);
        }
        return "redirect:/client";
    }
}
