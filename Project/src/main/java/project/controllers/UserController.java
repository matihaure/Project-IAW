package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.models.UserModel;
import project.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
		UserModel toReturn = userService.create(user);
		return new ResponseEntity<UserModel>(toReturn, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserModel> read(@PathVariable Integer id) {
		UserModel toReturn = userService.read(id);
		return new ResponseEntity<UserModel>(toReturn, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserModel> update(@PathVariable Integer id, @RequestBody UserModel user) {
		UserModel toReturn = userService.update(id, user);
		return new ResponseEntity<UserModel>(toReturn, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		userService.delete(id);
		return new ResponseEntity<String>("UserModel deleted.", HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<UserModel>> getAll() {
		List<UserModel> users = userService.getAll();
		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}
}