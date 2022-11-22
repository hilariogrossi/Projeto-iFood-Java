package dio.ProjetoiFoodJava.gof.controller;

import dio.ProjetoiFoodJava.gof.model.Client;
import dio.ProjetoiFoodJava.gof.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa a <b>Facade</b>, pois abstrai toda a
 * complexidade de integrações (Banco de Dados H2 e API do ViaCEp) em uma
 * interface simples e coesa (API REST)
 *
 * @author Hilário Grossi de Oliveira
 * @see <a href="https://github.com/hilariogrossi">GitHub</a>
 * @see <a href="https://linkedin.com/in/hilariogrossi">LinkedIn</a>
 */

@RestController
@RequestMapping("clients")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> searchAll() {
        return ResponseEntity.ok(clientService.searchAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.searchById(id));

    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        clientService.insert(client);
        return  ResponseEntity.ok(client);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();

    }

}
