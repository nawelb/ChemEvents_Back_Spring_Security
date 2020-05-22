//package fr.isika.microservice.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)  // pour prendre en compte l'annotation Secured dans la classe service
//public class SecurityConfig extends WebSecurityConfiguration {
//	@Autowired
//	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//		auth.jdbcAuthentication()
//		//.passwordEncoder(new BCryptPasswordEncoder())
//		.dataSource(dataSource)
//		.usersByUsernameQuery("select username as principal, password as credentials, true from user where username = ?")
//		.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_role where user_username = ?" )
//		.rolePrefix("ROLE_");
////		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
////		auth.inMemoryAuthentication().withUser("particulier").password(("{noop}123")).roles("PARTICULIER");
////		auth.inMemoryAuthentication().withUser("professionel").password(("{noop}123")).roles("PROFESSIONEL");
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//	
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/css/**", "/js/**").permitAll()
//					.anyRequest()
//						.authenticated()
//			//				.and()
//			//.formLogin()
//			//	.loginPage("/login")
//				;
//	}
//	
//}
