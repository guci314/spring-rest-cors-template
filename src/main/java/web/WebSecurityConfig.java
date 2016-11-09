package web;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.userDetailsService(userDetailsServiceBean());
	// }

//	@Override
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//		return new SSUserDetailsService();
//	}
	
	@Autowired
    private CustomAuthenticationProvider authProvider;
	
//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().httpBasic().and()
		        .authorizeRequests()
		        .antMatchers("/").permitAll()
		        .antMatchers("/api/registerService/register").permitAll()
		        .antMatchers("/api/registerService/login").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.HEAD, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
		.and().csrf().disable().formLogin().successHandler(new AuthenticationSuccessHandler() {
		    @Override
		    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		       //do nothing
		    }
		});
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("guci").password("123").roles("ADMIN");
		//auth.userDetailsService(userDetailsServiceBean());
		auth.authenticationProvider(authProvider);
	}
//
//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("root");
//		return driverManagerDataSource;
//	}
//
//	@Autowired
//	DataSource dataSource;

//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery(
//						"select phone_number as username,password as password, true as enabled from users where phone_number=?")
//				.authoritiesByUsernameQuery(
//						"select phone_number as username, 'ADMIN' as role from users where phone_number=?");
//	}
}


