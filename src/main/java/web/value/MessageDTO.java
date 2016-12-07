package web.value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import web.models.Message;
import web.models.User;

public class MessageDTO {
	private Integer id;
	
	private String title;
	
	private String content;
	
	private Integer user_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public MessageDTO(Message m){
		if (m==null) return;
		setId(m.getId());
		setContent(m.getContent());
		setTitle(m.getTitle());
		setUser_id(m.getOwner().getId());
	}
	
	public MessageDTO(){
		
	}
}
