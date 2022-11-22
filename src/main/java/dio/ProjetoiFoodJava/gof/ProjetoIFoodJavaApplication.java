package dio.ProjetoiFoodJava.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spting Boot gerado via Spring Initializr.
 * Os seguintes módulos foram selecionados:
 *  - Spring Data JPA
 *  - Spring Web
 *  - H2 Database
 *  - OpenFeign
 *
 * @author Hilário Grossi de Oliveira.
 * @see <a href="https://github.com/hilariogrossi">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/hilariogrossi">LinkedIn</a>
 */

@EnableFeignClients
@SpringBootApplication
public class ProjetoIFoodJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoIFoodJavaApplication.class, args);

	}

}
