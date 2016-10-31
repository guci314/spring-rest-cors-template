package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findUserByPhoneNumber(String phoneNumber);
}
