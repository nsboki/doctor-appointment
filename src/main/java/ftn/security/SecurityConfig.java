package ftn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import ftn.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .formLogin()
//                .loginPage("/#/login").permitAll()
//                .loginProcessingUrl("/api/login").permitAll()
//                .usernameParameter("username")
//                .successHandler((request, response, authentication) -> {
//                    response.setStatus(HttpServletResponse.SC_OK);
//                })
//                .failureHandler((request, response, exception) -> {
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                })
//        .and()
//            .httpBasic()
//        .and()
//            .logout()
//                .logoutUrl("/api/logout")
//                .deleteCookies("JSESSIONID")
//        .and()
//            .authorizeRequests()
//                .antMatchers("/home/**").authenticated()
//        .and()
//            .rememberMe()
//        .and()
//            .csrf()
//                .disable().exceptionHandling()
//                .authenticationEntryPoint(restAuthenticationEntryPoint);
//    }
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/users","/users/{id}").permitAll()
                .antMatchers("/doctors").hasRole("DOCTOR")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/login").permitAll()
                .usernameParameter("username")
                .permitAll()
                .and()
            .httpBasic()
                .and()
            .logout()
                .permitAll()
				.and().csrf()  .disable().exceptionHandling();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider);
    }
	

}
