package com.masai.Service;

import java.util.List;
import java.util.Optional;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.Client;


public interface ClientService {
	
    List<Client> getAllClients();

    Optional<Client> getClientById(Long id);

    Client createClient(Client client);

    void updateClient(Long id, Client client)throws PolicyNotFoundException;

    void deleteClient(Long id)throws PolicyNotFoundException;
}
