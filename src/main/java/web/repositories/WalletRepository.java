package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.models.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
	@Query("select w From Wallet w  Where w.phoneNumber = ?1")
	public Wallet findUserByPhoneNumber(String phoneNumber);
}
