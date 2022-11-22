package dio.ProjetoiFoodJava.gof.service;

import dio.ProjetoiFoodJava.gof.model.Client;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente.
 * Com isso, se necessário, pode-se ter multiplas implementações dessa
 * mesma interface.
 *
 * @author Hilário Grossi de Oliveira
 * @see <a href="https://github.com/hilariogrossi">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/hilariogrossi">LinkedIn</a>
 */

public interface ClientService {
    Iterable<Client> searchAll();
    Client searchById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);

}
