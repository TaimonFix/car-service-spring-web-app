package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
