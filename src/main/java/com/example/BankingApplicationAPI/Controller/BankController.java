package com.example.BankingApplicationAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingApplicationAPI.Model.Account;
import com.example.BankingApplicationAPI.Service.BankingService;

@RestController
@RequestMapping
public class BankController {
	
	@Autowired
	private BankingService bankingService;
	
	@PostMapping("/accounts")
	public String addAccount(@RequestBody Account account)
	{
		
		bankingService.saveAccount(account);
		return "account added succesfully";
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/deposit/{amount}/{id}")
 public String depositAmount(@RequestParam long id,@RequestParam double amount)
   {
		
		
	bankingService.deposit(id,amount);
	return "deposited succesfully";
	
		
	}
@RequestMapping(method = RequestMethod.POST,value = "/transfer/{amount}/{fromId}/{toId}")
	public String transfer(@RequestParam long fromId,@RequestParam long toId,@RequestParam double amount)
{
	bankingService.transfer(fromId,toId,amount);
	return "success";
}
	
	
	

}
