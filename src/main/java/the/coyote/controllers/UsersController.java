package the.coyote.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import the.coyote.model.entities.UsersModel;
import the.coyote.model.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

//  quando precisar usar a inclusão e alteração com validações diferentes.... usar assim.	
//	@PostMapping
//	@PutMapping

	
	// ver porque esta passando valores nulos para o repositório
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody UsersModel saveUsers(@Valid UsersModel usersModel) {
		usersRepository.save(usersModel);
		return usersModel;
	}

	@GetMapping
	public  Iterable<UsersModel> getAll() {
		return usersRepository.findAll();
	}
	
	@GetMapping(path = "/search/{text}")
	public  Iterable<UsersModel> getText(@PathVariable String text) {
		return usersRepository.findByEmailContainingIgnoreCase(text);
	}	

	@GetMapping(path = "/page/{pageNumber}/{itens}")
	public Iterable<UsersModel> getByPage(@PathVariable int pageNumber, @PathVariable int itens) {
		if (itens > 20) itens = 20;  // se a requisição tiver mais que 20 itens
		Pageable page = PageRequest.of(pageNumber, itens);
		return usersRepository.findAll(page);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsersModel> getFindId(@PathVariable int id) {
		return usersRepository.findById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void putUsers(@PathVariable int id) {
		usersRepository.deleteById(id);
	}
	
}
