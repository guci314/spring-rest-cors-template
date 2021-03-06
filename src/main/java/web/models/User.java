package web.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAPP_Users")
//@NamedQueries({
//    @NamedQuery(
//            name="findUserByPhoneNumber",
//            query="select u From User u Where u.phoneNumber = :phoneNumber"
//        )
//
//})
public class User implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(nullable=false,unique=true)
	private String phoneNumber;
	@Column(nullable=false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="user")
	@JsonBackReference
	private List<Vehicle> vehicles =new ArrayList<Vehicle>();
	
//	@OneToMany(fetch = FetchType.LAZY,mappedBy="owner")
//	@JsonBackReference
//	private List<Message> messages =new ArrayList<Message>();
	
//	public List<Message> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getPassword() {
		return AESOperator.getInstance().decrypt(password);
	}

	public void setPassword(String password) {
		this.password =AESOperator.getInstance().encrypt(password);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User()
	{

	}
	
	public User(String name)
	{
		this.name = name;
	}
}
