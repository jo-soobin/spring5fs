package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ChangePwdController;
import controller.LogoutController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	/*
	 * @Bean public RegisterControllerWithLocalValidator
	 * registerControllerLocalValidator() { RegisterControllerWithLocalValidator
	 * controller = new RegisterControllerWithLocalValidator();
	 * controller.setMemberRegisterService(memberRegSvc); return controller; }
	 */

	/*
	 * @Bean public RegisterControllerWithGlobalValidator
	 * registerControllerGlobalValidator() { RegisterControllerWithGlobalValidator
	 * controller = new RegisterControllerWithGlobalValidator();
	 * controller.setMemberRegisterService(memberRegSvc); return controller; }
	 */
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	
}
