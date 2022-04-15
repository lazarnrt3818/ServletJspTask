package it.engineering.webapp.service;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.User;
import it.engineering.webapp.domain.dto.UserDto;


public interface UserService {
	public void save(User user);
	public Optional<User> find(Long id);
	public void remove(Long id);
	public List<User> findAll();
	public void update(User user);
	public UserDto login(String username,String password);
}
