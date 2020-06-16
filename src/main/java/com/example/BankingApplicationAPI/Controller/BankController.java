package com.example.BankingApplicationAPI.Controller;

import com.example.BankingApplicationAPI.Model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BankingApplicationAPI.Model.Account;
import com.example.BankingApplicationAPI.Service.BankingService;

import java.util.List;

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

	@RequestMapping(method = RequestMethod.POST,value = "/withdraw/{amount}/{id}")
	public String withdraw(@RequestParam long id,@RequestParam double amount)
	{
		bankingService.withDraw(id,amount);
		return "success";
	}

	@GetMapping("/statement/{id}")
	public ResponseEntity<?> getStatement(@RequestParam long id) throws Exception
	{


		return new ResponseEntity<Object>(bankingService.getAccountStatement(id), HttpStatus.OK);
	}
}
