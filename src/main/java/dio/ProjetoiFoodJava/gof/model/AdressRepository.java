package dio.ProjetoiFoodJava.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Opcional colocar
public interface AdressRepository extends CrudRepository<Adress, String> {

}
