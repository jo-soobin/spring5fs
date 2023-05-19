package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtx {
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
	
	@Bean(initMethod = "connect", destroyMethod = "close") //초기 메소드와 종료 메소드를 지정해준 수 bean으로 사용
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host");
		return client;
	}
	
}
