package dio.ProjetoiFoodJava.gof.service;

import dio.ProjetoiFoodJava.gof.model.Adress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client HTTP criado via <b>OpenFeign</b> para consumo da API do <b>ViaCEP</b>
 *
 * @author Hilário Grossi de Oliveira
 * @see <a href="http://github.com/hilariogrossi">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/hilariogrossi">LinkedIn</a>
 *
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json")
    // ou @GetMapping("/{cep}/json")
    Adress searchCep(@PathVariable("cep") String cep);

}
