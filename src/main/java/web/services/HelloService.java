package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HelloService {
	
	public String sayHello(){
		return "hello world";
	}

}
