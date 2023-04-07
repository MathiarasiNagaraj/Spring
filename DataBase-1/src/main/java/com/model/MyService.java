package com.model;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("Myservice")
@Transactional
public class MyService {

	public AccountsDAO getDao() {
		return dao;
	}

	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}

	@Autowired
	private AccountsDAO dao;
    @Transactional(propagation = Propagation.REQUIRED)
	public void doService(int id,int amount)
	{
		AccountsDTO dto=dao.findByID(id);
		dto.setAmount(amount);
	     dao.updateUser(dto);
	}
}
