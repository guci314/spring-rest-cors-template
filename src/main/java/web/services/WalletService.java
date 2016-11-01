package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.Wallet;
import web.repositories.WalletRepository;

@Service
public class WalletService {
	@Autowired
	private WalletRepository walletRepository;
	
	public boolean create(String phoneNumber){
		Wallet w=new Wallet(phoneNumber);
		walletRepository.saveAndFlush(w);
		return true;
	}
	
	public boolean deposit(String phoneNumber,float amount){
		Wallet w=walletRepository.findUserByPhoneNumber(phoneNumber);
		if (w==null) return false;
		w.deposit(amount);
		walletRepository.saveAndFlush(w);
		return true;
	}
	
	public boolean withdraw(String phoneNumber,float amount){
		Wallet w=walletRepository.findUserByPhoneNumber(phoneNumber);
		if (w==null) return false;
		w.withdraw(amount);
		walletRepository.saveAndFlush(w);
		return true;
	}
	
	public float getBalance(String phoneNumber){
		Wallet w=walletRepository.findUserByPhoneNumber(phoneNumber);
		if (w==null) return 0;
		return w.getBalance();
	}
}
