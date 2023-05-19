package main;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import spring.Client;
import spring.Client2;

public class Main {

	public static void main(String[] args) throws IOException {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);

		Client client = ctx.getBean("client1",Client.class); //"client1" 은 bean이 하나라면 생략 가능.
		Client2 client2 = ctx.getBean("client2",Client2.class);
		client.send();
		client2.send();
		
		ctx.close();
	}

}