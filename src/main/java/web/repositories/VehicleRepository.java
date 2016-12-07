package web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	@Query("select v from Vehicle v where v.user.phoneNumber = ?1")
	public List<Vehicle> findVehiclesByPhoneNumber(String phoneNumber);
	
	@Query("select v from Vehicle v where v.plate = ?1")
	public List<Vehicle> findVehiclesByPlate(String plate);
}
