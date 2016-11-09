package web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	@Query("select m From Message m Where m.owner.phoneNumber = ?1")
	public List<Message> findMessageByPhoneNumber(String phoneNumber);
}
