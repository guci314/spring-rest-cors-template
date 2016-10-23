package web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import web.models.User;
import web.repositories.UserRepository;
import web.services.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<User> list(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return this.userRepository.findAll();
    }

	//, consumes = {"application/json"}  HttpEntity<?>
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public HttpEntity<?> create(@RequestBody User user,HttpServletResponse response) {
		user.setId(null);
	    user = this.userRepository.saveAndFlush(user);
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    //return user;
	    HttpHeaders headers = new HttpHeaders();
	    return new HttpEntity<Object>(headers);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User find(@PathVariable("id") Integer id,HttpServletResponse response) {
	    User user = this.userRepository.findOne(id.longValue());
	    if (user == null) {
	      throw new RuntimeException("user id not found");
	    }
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    return user;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public User updateUser(@RequestBody User user, @PathVariable Integer id,HttpServletResponse response) {
	    user.setId(id.longValue());
	    return this.userRepository.saveAndFlush(user);
	  }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		this.userRepository.delete(id.longValue());
	}
}
