package br.com.aweb.pesquisa_satisfacao.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracoesDeSeguranca {

    // @Bean
    // public UserDetailsService dadosUsuario() {

    // UserDetails usuario1 = User.builder()
    // .username("murilo@email.com")
    // .password("{noop}murilo123")
    // .build();

    // UserDetails usuario2 = User.builder()
    // .username("herrick@email.com")
    // .password("{noop}herrick123")
    // .build();

    // return new InMemoryUserDetailsManager(usuario1, usuario2);
    // }

    @Bean
    public SecurityFilterChain filtroSeguranca(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(req -> {
                    req.requestMatchers("/css/**", "/js/**", "img/**").permitAll();
                    req.anyRequest().authenticated();
                })

                .formLogin(form -> form.loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())
                .rememberMe(rememberMe -> rememberMe.key("lembrarDeMim"))
                .build();
    }

    @Bean
    public PasswordEncoder condificadorSenha() {
        return new BCryptPasswordEncoder();
    }

};