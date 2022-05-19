package ca.qc.barreau.userws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.qc.barreau.userws.model.User;
import ca.qc.barreau.userws.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{userId}")
	public User findAll(@PathVariable int userId) {
		return userService.findById(userId);
	}

	@DeleteMapping("/users/{userId}")
	public void delete(@PathVariable int userId) {
		userService.deleteById(userId);
	}

	@PostMapping("/users")
	public void save(@RequestBody User user) {
		user.setId(0);
		userService.save(user);
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}
}
