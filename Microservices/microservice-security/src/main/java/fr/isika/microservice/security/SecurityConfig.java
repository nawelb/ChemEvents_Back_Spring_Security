//package fr.isika.microservice.security;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	
//	
//	@Autowired
//	private DataSource dataSource;
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder passwordEncoder = passwordEncoder();
//		System.out.println("*********************");
//		System.out.println(passwordEncoder.encode("123"));
//		System.out.println("*********************");
//			auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select username as principal, password credentials, true from user where username = ?")
//			.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_role where user_username = ?" )
//			.passwordEncoder(passwordEncoder);
////			.rolePrefix("ROLE_");
////		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
////		auth.inMemoryAuthentication().withUser("particulier").password(("{noop}123")).roles("PARTICULIER");
////		auth.inMemoryAuthentication().withUser("professionel").password(("{noop}123")).roles("PROFESSIONEL");
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    
//		http.formLogin();
//		//http.authorizeRequests().antMatchers("/user/**", "/find**/**", "/add**/**", "/supprimer**/**","/modifier**/**", "/save**/**").hasRole("ADMIN");
//		http
//	        .authorizeRequests()
//	            .anyRequest()
//	            .authenticated();
//	}
////		public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
////			auth.jdbcAuthentication()
////////.passwordEncoder(new BCryptPasswordEncoder())
//////.dataSource(dataSource)
//////.usersByUsernameQuery("select username as principal, password as credentials, true from user where username = ?")
//////.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_role where user_username = ?" )
//////.rolePrefix("ROLE_");
////			auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
////			auth.inMemoryAuthentication().withUser("particulier").password(("{noop}123")).roles("PARTICULIER");
////			auth.inMemoryAuthentication().withUser("professionel").password(("{noop}123")).roles("PROFESSIONEL");
////}
//	
//	
//	
//	
//	
//	
//	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	   return  new BCryptPasswordEncoder();
//	}
//	
//
//}
//
//
//
//
////@Autowired
////DataSource datasource;
////
////@Override
////protected void configure(HttpSecurity http) throws Exception {
////    http
////        .authorizeRequests()
////            .anyRequest()
////            .fullyAuthenticated()
////            .and()
////        .formLogin()
////            .loginPage("/login")
////            .failureUrl("/login?error")
////            .permitAll()
////            .and()
////        .logout()
////            .logoutUrl("/logout")
////            .logoutSuccessUrl("/login?logout")
////            .permitAll()
////            .and()
////        .csrf();
////}
////
////@Override
////protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////    auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder());
////}
////
////@Bean
////public PasswordEncoder passwordEncoder() {
////    PasswordEncoder encoder = new BCryptPasswordEncoder();
////    return encoder;
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//////import org.springframework.context.annotation.Bean;
////////package fr.isika.microservice.security;
////////
////////import javax.sql.DataSource;
////////
////////import org.springframework.beans.factory.annotation.Autowired;
////////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////////import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//////import org.springframework.security.crypto.password.PasswordEncoder;
////////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////////import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//////
////@Configuration
//////@EnableWebSecurity
//////@EnableGlobalMethodSecurity(securedEnabled = true)  // pour prendre en compte l'annotation Secured dans la classe service
////public class SecurityConfig extends WebSecurityConfiguration {
//////	
//////	@Bean
//////	public PasswordEncoder passwordEncoder() {
//////		return new BCryptPasswordEncoder();
//////	}
//////
//////
////	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//////		public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//////		auth.jdbcAuthentication()
////////		//.passwordEncoder(new BCryptPasswordEncoder())
////////		.dataSource(dataSource)
////////		.usersByUsernameQuery("select username as principal, password as credentials, true from user where username = ?")
////////		.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_role where user_username = ?" )
////////		.rolePrefix("ROLE_");
//////		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
//////		auth.inMemoryAuthentication().withUser("particulier").password(("{noop}123")).roles("PARTICULIER");
//////		auth.inMemoryAuthentication().withUser("professionel").password(("{noop}123")).roles("PROFESSIONEL");
////		}
////////	
////////	@SuppressWarnings("deprecation")
////////	@Bean
////////	public static NoOpPasswordEncoder passwordEncoder() {
////////	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
////////	}
////////	
////////	//regle de sécurité, si ca reste vide = pas de controle open application 
////	protected void configure(HttpSecurity http) throws Exception {
////////		http
////////			.authorizeRequests()
////////				.antMatchers("/css/**", "/js/**").permitAll()
////////					.anyRequest()
////////						.authenticated()
////////							.and()
////////			.formLogin()
////////			//	.loginPage("/login")
////////				;
//////		http.formLogin();
//////		//http.httpBasic();
//////		http.authorizeRequests().anyRequest().authenticated();
////	}
////////	
////}
