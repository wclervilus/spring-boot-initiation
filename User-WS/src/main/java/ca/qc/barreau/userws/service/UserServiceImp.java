package ca.qc.barreau.userws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.qc.barreau.userws.model.User;
import ca.qc.barreau.userws.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	private UserRepository userRepository;

	@Autowired
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findById(int userId) {
		return userRepository.findById(userId);
	}

	@Override
	public void deleteById(int userId) {
		userRepository.deleteById(userId);
	}
}
