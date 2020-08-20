package com.seminario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().
			authorizeRequests()
				//.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.GET, "/fichas").hasAnyRole("ADMIN","USER")
				.antMatchers("/fichas/{id}").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.GET, "/paroquias").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.GET, "/exportar").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.GET,"/cadastrarFicha").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET,"/deletar/{id}").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/cadastrarFicha").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET,"/atualizarFicha").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/atualizarFicha").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET,"/atualizar/{id}").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET,"/usuario/users").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET,"/usuario/getusuario/{id}").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/usuario/logar").defaultSuccessUrl("/",true)
				.failureUrl("/usuario/logar").permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/usuario/logar").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder ());
	}	

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
	}
}
