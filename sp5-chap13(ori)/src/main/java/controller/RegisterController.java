package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

	private MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(
			MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "register/step2";

		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}

/*	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq) {
	//public String handleStep3(@ModelAttribute ("formData")RegisterRequest regReq) {	
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			
			return "register/step2"; 
			 //현재 경로를 기준으로 상대경로를 사용한다. "http://localhost:8181/sp5-chap11/register/step2"를 기준으로
			//상대경로인  "http://localhost:8181/sp5-chap11/register/step3을 리다이렉트  경로로 사용한다.
		}
	}
*/	
}
