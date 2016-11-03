package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

//curl -i -X POST -H "Content-Type: application/json" http://localhost:8081/api/helloService/sayHello -u user:password


@Service
public class HelloService {
	
	//@Secured("ROLE_USER")
	public String sayHello(){
		return "hello world 3333";
	}

}
