package web.controllers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.models.Message;
import web.services.MessageService;
import web.value.MessageDTO;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = { RequestMethod.POST })
	public MessageDTO addMessage(@RequestBody MessageDTO mes) {
		try {
			return messageService.AddMessage(mes);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}",method = { RequestMethod.PUT })
	public MessageDTO update(@RequestBody MessageDTO mes) {
		try {
			return messageService.Update(mes);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public boolean deleteMessage(@PathVariable("id") Integer id) {
		try {
			return messageService.DeleteMessage(id);
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/findMessageByPhoneNumber", method = { RequestMethod.GET })
	public List<MessageDTO> findMessageByPhoneNumber(String phoneNumber) {
		try {
			return messageService.FindMessageByPhoneNumber(phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<MessageDTO> findAll() {
		try {
			return messageService.FindAll();
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public MessageDTO getMessage(@PathVariable("id") Integer id) {
		try {
			return messageService.GetMessage(id);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
