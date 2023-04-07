package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.exception.InsufficientBalance;
import com.model.AccountsDAO;
import com.model.AccountsDTO;
import com.model.MyService;
import com.model.TransactionService;
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})


public class DataBase1Application {

	public static void main(String[] args) throws InsufficientBalance {
		ConfigurableApplicationContext ctx=SpringApplication.run(DataBase1Application.class, args);
	
		AccountsDAO dao=ctx.getBean("acdo",AccountsDAO.class);

		MyService myservice=ctx.getBean("Myservice",MyService.class);
		
		myservice.doService(100, 300000);
		
		TransactionService tss=ctx.getBean("tss",TransactionService.class);
		tss.moneyTransfer(100, 200, 1000);
	}

}
