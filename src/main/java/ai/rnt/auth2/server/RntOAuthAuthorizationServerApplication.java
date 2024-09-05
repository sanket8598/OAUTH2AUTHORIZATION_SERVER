package ai.rnt.auth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class RntOAuthAuthorizationServerApplication {

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RntOAuthAuthorizationServerApplication.class, args);
	}

}
