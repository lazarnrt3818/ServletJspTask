package it.engineering.webapp.service;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.UserEntity;
import it.engineering.webapp.domain.dto.UserDto;


public interface UserService {
	public void save(UserEntity user);
	public Optional<UserEntity> find(Long id);
	public void remove(Long id);
	public List<UserEntity> findAll();
	public void update(UserEntity user);
	public UserDto login(String username,String password);
}
