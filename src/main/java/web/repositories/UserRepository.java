package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u From User u  Where u.phoneNumber = ?1")
	public User findUserByPhoneNumber(String phoneNumber);
}
