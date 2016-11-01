package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.User;
import web.models.Vehicle;
import web.repositories.UserRepository;
import web.repositories.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<Vehicle> findVehiclesByPhoneNumber(String phoneNumber){
		return vehicleRepository.findVehiclesByPhoneNumber(phoneNumber);
	}
	
	public Vehicle bindPlate(String phoneNumber,String plate,boolean autoCharge){
		List<Vehicle> vs=vehicleRepository.findVehiclesByPhoneNumber(phoneNumber);
		boolean isBinded=false;
		for(Vehicle v:vs){
			if (v.getPlate().equals(plate)) isBinded=true;
		}
		if (isBinded) return null;
		User u=userRepository.findUserByPhoneNumber(phoneNumber);
		if (u==null) return null;
		Vehicle v=new Vehicle();
		v.setUser(u);
		v.setPlate(plate);
		v.setAutoCharge(autoCharge);
		vehicleRepository.saveAndFlush(v);
		return v;
	}
	
	public boolean deleteVehicle(Long id){
		vehicleRepository.delete(id);
		vehicleRepository.flush();
		return true;
	}
}
