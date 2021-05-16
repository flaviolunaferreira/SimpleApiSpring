package the.coyote.model.repositories;

// CrudRepository retorna um crud mais simples
// vou user o pageRepository para me dar a possibilidade de paginação
import org.springframework.data.repository.PagingAndSortingRepository ;

import the.coyote.model.entities.UsersModel;

public interface UsersRepository extends PagingAndSortingRepository<UsersModel, Integer>{

	public Iterable<UsersModel> findByEmailContainingIgnoreCase(String texto);
	
}
