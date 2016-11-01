package web.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	 * 所属用户
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonManagedReference
	User user;
	/*
	 * 车牌号
	 */
	@Column(nullable=false)
	String plate;
	/*
	 * 是否自动扣费
	 */
	@Column(nullable=false)
	boolean autoCharge=true;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public boolean isAutoCharge() {
		return autoCharge;
	}
	public void setAutoCharge(boolean autoCharge) {
		this.autoCharge = autoCharge;
	}
	
}
