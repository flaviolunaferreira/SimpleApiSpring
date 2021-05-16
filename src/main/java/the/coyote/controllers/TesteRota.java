package the.coyote.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteRota {
	// @RequestMapping(method = RequestMethod.GET, path = "/")
	@GetMapping(path = "/teste")
	public String ola() {
		return "Hello World!!";
	}
}
