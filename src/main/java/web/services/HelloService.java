package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.repositories.ProductRepository;

@Service
public class HelloService {
	@Autowired
	private ProductRepository productRepository;

	public String sayHello(){
		return "hello world";
	}

}
