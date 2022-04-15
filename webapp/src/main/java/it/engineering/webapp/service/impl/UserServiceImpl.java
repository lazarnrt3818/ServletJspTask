package it.engineering.webapp.service.impl;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.User;
import it.engineering.webapp.domain.dto.UserDto;
import it.engineering.webapp.repository.UserRepository;
import it.engineering.webapp.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl() {
		this.userRepository = new UserRepository();
	}

	@Override
	public UserDto login(String username, String password) {
		List<User> users = userRepository.getAll();
		
		for(User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return new UserDto(user.getUsername(),user.getFirstName(), user.getLastName());
			}
		}
								
			return null;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public Optional<User> find(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public void remove(Long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.getAll();
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

}
