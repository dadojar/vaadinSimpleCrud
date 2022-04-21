package dasa.crud;


import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import dasa.crud.ui.LoginView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//https://www.youtube.com/watch?v=nmV1k9RmtFo

@SpringBootApplication
public class CrudApplication extends VaadinWebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		setLoginView(http, LoginView.class);
	}

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withUsername("davide")
						.password("{noop}password")
						.roles("ADMIN")
						.build(),
				User.withUsername("sara")
						.password("{noop}password")
						.roles("ADMIN")
						.build()
		);
	}

}
