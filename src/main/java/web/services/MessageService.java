package web.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.Message;
import web.models.User;
import web.repositories.MessageRepository;
import web.repositories.UserRepository;
import web.value.MessageDTO;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public MessageDTO AddMessage(MessageDTO m){
		Message mes=new Message();
		mes.setTitle(m.getTitle());
		mes.setContent(m.getContent());
		User u=userRepository.getOne(m.getUser_id());
		mes.setOwner(u);
		mes=messageRepository.saveAndFlush(mes);
		return new MessageDTO(mes);
	}
	
	public boolean DeleteMessage(Long id){
		messageRepository.delete(id);
		return true;
	}
	
	public MessageDTO Update(MessageDTO dto){
		Message m=messageRepository.getOne(dto.getId());
		m.setTitle(dto.getTitle());
		m.setContent(dto.getContent());
		User u=userRepository.findOne(dto.getUser_id());
		m.setOwner(u);
		return new MessageDTO(m);
	}
	
	public MessageDTO GetMessage(Long id){
		Message m=messageRepository.getOne(id);
		return new MessageDTO(m);
	}
	
	public List<MessageDTO> FindMessageByPhoneNumber(String phoneNumber){
		List<Message> ml=messageRepository.findMessageByPhoneNumber(phoneNumber);
		List<MessageDTO> dl=new ArrayList<MessageDTO>();
		for (Iterator iterator = ml.iterator(); iterator.hasNext();) {
			Message message = (Message) iterator.next();
			MessageDTO d=new MessageDTO(message);
			dl.add(d);
		}
		return dl;
	}
	
	public List<MessageDTO> FindAll(){
		List<Message> ml=messageRepository.findAll();
		List<MessageDTO> dl=new ArrayList<MessageDTO>();
		for (Iterator iterator = ml.iterator(); iterator.hasNext();) {
			Message message = (Message) iterator.next();
			MessageDTO d=new MessageDTO(message);
			dl.add(d);
		}
		return dl;
	}
}
