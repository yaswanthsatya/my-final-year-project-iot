package net.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.springmvc.entity.Account;
import net.springmvc.entity.Customer;
import net.springmvc.entity.Loan;
import net.springmvc.entity.Recharge;
import net.springmvc.service.AccountService;
import net.springmvc.service.CustomerService;
import net.springmvc.service.LoanService;
import net.springmvc.service.RechargeService;

@Controller
public class IndexCotroller 
{
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoanService loanService;
	@Autowired
	private RechargeService rechargeService;
	@Autowired
	private CustomerService customerService;

	
//	public int blns = 20000;	
	@RequestMapping("/")
	public String startPage()
	{
		return "startpage";
	}
	
	@RequestMapping("/accountcreation")
	public String accountCreation()
	{
		return "accountcreation";
	}
	
	@RequestMapping("/accCrtd")
	public String accountCrtd(@ModelAttribute("account") Account theAccount,Model model)
	{
		accountService.saveAccount(theAccount);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard(Model theModel,Account theAccount)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		theAccount.setBalance(500);
		mv.addObject("bal",theAccount.getBalance());
		return mv;
	}
	
	
	@RequestMapping("/loan")
	public String LoanPage()
	{
		return "loanapplication";
	}
	
	@PostMapping("/save")
	public String Page(@ModelAttribute("loan") Loan theLoan,Model model)
	{
		loanService.saveLoan(theLoan);
		return "index";
	}
	
	@RequestMapping("/transfer")
	public ModelAndView transferPage(ModelAndView mv)
	{
//		List<Customer> theCustomer = customerService.getCustomers();
//		mv.addObject("acc", theCustomer);
		mv.setViewName("transfer");
		return mv;
	}
	
	@RequestMapping("/bills")
	public String billPage()
	{
		return "bills";
	}
	
	@PostMapping("/recharge")
	public String phonePage(Model theModel)
	{
		List<Account> theAccount = accountService.getAccounts();
		theModel.addAttribute("acc", theAccount);
		return "recharge";
	}
	
	@PostMapping("/rechargedone")
	public String Page(@ModelAttribute Recharge theRecharge, Model model)
	{
		rechargeService.saveRecharge(theRecharge);
		return "redirect:/index";
	}
	
	@RequestMapping("/contactus")
	public String contactPage()
	{
		return "contactus";
	}
	
	@RequestMapping("/history")
	public String historyPage(Model theModel)
	{
		List<Recharge> theRecharge = rechargeService.getRecharge();
		theModel.addAttribute("rech", theRecharge);
		return "history";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "redirect:/";
	}
}
