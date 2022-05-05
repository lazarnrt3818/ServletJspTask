package it.engineering.webapp.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.engineering.webapp.domain.UserEntity;
import it.engineering.webapp.domain.dto.UserDto;
import it.engineering.webapp.repository.JpaCrudRepository;
import it.engineering.webapp.repository.UserRepository;
import it.engineering.webapp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private JpaCrudRepository<UserEntity, Long> userRepository;

	@Override
	public UserDto login(String username, String password) {
		List<UserEntity> users = userRepository.getAll();
		
		for(UserEntity user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return new UserDto(user.getUsername(),user.getFirstName(), user.getLastName());
			}
		}
								
			return null;
	}

	@Override
	public void save(UserEntity user) {
		userRepository.save(user);
	}

	@Override
	public Optional<UserEntity> find(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public void remove(Long id) {
		userRepository.delete(id);
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.getAll();
	}

	@Override
	public void update(UserEntity user) {
		userRepository.update(user);
	}

}
