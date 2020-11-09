package oit.is.z0835.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // $ sshrun htpasswd -nbBC 10 user1 pAssw0rd
    auth.inMemoryAuthentication().withUser("takashi")
        .password("$2y$10$ZtQdV/i9/WqsCNd2hIq2OOpjzQnhUCj3T40j2c1T46GxWAorgpufy").roles("TAKASHI");
    auth.inMemoryAuthentication().withUser("aki")
        .password("$2y$10$ZtQdV/i9/WqsCNd2hIq2OOpjzQnhUCj3T40j2c1T46GxWAorgpufy").roles("AKI");
    auth.inMemoryAuthentication().withUser("ながい")
        .password("06050605").roles("USER");
    auth.inMemoryAuthentication().withUser("しゅん")
        .password("$2y$10$ZtQdV/i9/WqsCNd2hIq2OOpjzQnhUCj3T40j2c1T46GxWAorgpufy").roles("USER");


    // auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("pAssw0rd")).roles("USER");
    // auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("pAssw0rd")).roles("ADMIN");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.formLogin();
    http.authorizeRequests().antMatchers("/lec02/**").authenticated();
    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }



}
