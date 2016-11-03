package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .httpBasic().and()
            .authorizeRequests()
              .antMatchers(HttpMethod.PUT,"/api/**").hasRole("USER")//permitAll();
              .antMatchers(HttpMethod.POST, "/api/**").hasRole("USER")
              .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER")
              .antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
              .antMatchers(HttpMethod.HEAD, "/api/**").hasRole("USER")
              .antMatchers(HttpMethod.PATCH, "/api/**").hasRole("USER")
              .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll();
//            .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("guci").password("123").roles("USER");
    }
}
