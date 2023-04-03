package com.masai.ServiceIMPL;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.Client;
import com.masai.Repository.ClientRepository;
import com.masai.Service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> getClientById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void updateClient(Long id, Client client) throws PolicyNotFoundException {
		Optional<Client> optionalClient = clientRepository.findById(id);
		if (!optionalClient.isPresent()) {
			throw new PolicyNotFoundException("Client not found with id " + id);
		}
		client.setId(id);
		clientRepository.save(client);
	}

	@Override
	public void deleteClient(Long id) throws PolicyNotFoundException {
		Optional<Client> optionalClient = clientRepository.findById(id);
		if (!optionalClient.isPresent()) {
			throw new PolicyNotFoundException("Client not found with id " + id);
		}
		clientRepository.deleteById(id);
	}
}
