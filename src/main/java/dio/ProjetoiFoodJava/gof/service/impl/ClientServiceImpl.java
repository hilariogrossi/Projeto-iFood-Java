package dio.ProjetoiFoodJava.gof.service.impl;

import dio.ProjetoiFoodJava.gof.model.Adress;
import dio.ProjetoiFoodJava.gof.model.AdressRepository;
import dio.ProjetoiFoodJava.gof.model.Client;
import dio.ProjetoiFoodJava.gof.model.ClientRepository;
import dio.ProjetoiFoodJava.gof.service.ClientService;
import dio.ProjetoiFoodJava.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClientService}, a qual pode ser injetada
 * pelo Spring (via {@link Autowired}). Com isso, como essa classe é um {@link Service},
 * ela será tratada como um <b>Singleton</b>.
 *
 * @author Hilário Grossi de Oliveira
 * @see <a href="https://github.com/hilariogrossi">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/hilariogrossi">LinkedIn</a>
 *
 */

public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private ViaCepService viaCepService;

    private void extractedClientAndSaveWithCep(Client client) {
        String cep = client.getAdress().getCep();
        Adress adress = adressRepository.findById(cep).orElseGet(() -> {
            Adress newAdress = viaCepService.searchCep(cep);
            adressRepository.save(newAdress);
            return newAdress;

        });

        client.setAdress(adress);

        clientRepository.save(client);

    }

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();

    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> findById = clientRepository.findById(id);
        return findById.get();

    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();

    }

    @Override
    public Client findById(Long id) {
        Optional<Client> findById = clientRepository.findById(id);
        return findById.get();

    }

    @Override
    public void insert(Client client) {
        extractedClientAndSaveWithCep(client);

    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> findByIdDataBase = clientRepository.findById(id);
        if (findByIdDataBase.isPresent()) {
            extractedClientAndSaveWithCep(client);

        }

    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);

    }

}
