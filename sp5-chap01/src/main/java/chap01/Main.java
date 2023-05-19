package chap01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {

	public static void main(String[] args) {
		//singleton객체 생성
		//스프링은 싱글톤 객체를 만들어서 사용한다.
		//일반 자바 프로그래밍에서는 객체 만들 때 생성자를 사용.(private).
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("(g1 == g2) = "+(g1 == g2));
		ctx.close();
	}

}
