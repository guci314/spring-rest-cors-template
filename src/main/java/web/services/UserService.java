package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.Product;
import web.models.User;
import web.repositories.ProductRepository;
import web.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User u)
	{
		return this.userRepository.save(u);
	}

	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}
	
	public User findById(long id){
		return this.userRepository.findOne(id);
	}
	
	public void delete(long id){
		this.userRepository.delete(id);
	}
}
