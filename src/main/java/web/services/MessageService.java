package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.Message;
import web.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	public boolean AddMessage(Message m){
		messageRepository.saveAndFlush(m);
		return true;
	}
	
	public boolean DeleteMessage(Long id){
		messageRepository.delete(id);
		return true;
	}
	
	public List<Message> FindMessageByPhoneNumber(String phoneNumber){
		return messageRepository.findMessageByPhoneNumber(phoneNumber);
	}
}
