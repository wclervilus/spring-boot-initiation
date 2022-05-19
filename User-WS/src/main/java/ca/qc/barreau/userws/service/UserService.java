package ca.qc.barreau.userws.service;

import java.util.List;

import ca.qc.barreau.userws.model.User;

public interface UserService {
	public List<User> findAll();
	public void save(User user);
	public User findById(int userId);
	public void deleteById(int userId);
}
