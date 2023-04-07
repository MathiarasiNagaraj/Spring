package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exception.InsufficientBalance;

@Service("bss")
@Transactional
public class BankingService {

	@Autowired
	private AccountsDAO dao;
	@Transactional(propagation = Propagation.MANDATORY)
	void doCredit(int crid,int amount)
	{
		AccountsDTO dto=dao.findByID(crid);
		dto.setAmount(amount+dto.getAmount());
		dao.updateUser(dto);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {InsufficientBalance.class})
	void doDebit(int drid,int amount) throws InsufficientBalance
	{
		AccountsDTO dto=dao.findByID(drid);
		int oldamount=dto.getAmount();
		if(oldamount<amount)
		{
			throw new InsufficientBalance("Insufficient balance");
			
		}
		int newamount=oldamount-amount;
		dto.setAmount(newamount);
		dao.updateUser(dto);
	}
}