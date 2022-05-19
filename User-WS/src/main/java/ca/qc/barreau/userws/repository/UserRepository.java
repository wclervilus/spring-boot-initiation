package ca.qc.barreau.userws.repository;

import java.util.List;

import ca.qc.barreau.userws.model.User;

public interface UserRepository {
	public List<User> findAll();

	public User findById(int userId);

	public void save(User user);

	public void deleteById(int userId);
}
