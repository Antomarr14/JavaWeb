package com.ESFE.Asistencias.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
    @Bean
    public UserDetailsManager customUsers(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        // Set the query to retrieve user details by username
        users.setUsersByUsernameQuery(
                "select login, clave, status from usuarios where login = ?"
        );

        // Set the query to retrieve user authorities by username
        users.setAuthoritiesByUsernameQuery(
                "select u.login, r.nombre from usuario_rol ur " +
                        "inner join usuarios u on u.id = ur.usuario_id " +
                        "inner join roles r on r.id = ur.rol_id " +
                        "where u.login = ?"
        );

        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/dist/**", "/plugins/**").permitAll()
                        .requestMatchers("/", "/privacy", "/terms").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll());

//                .logout(logout -> logout
//                        .logoutUrl("/logout") // URL para logout
//                        .logoutSuccessUrl("/login") // URL para redirigir después del logout
//                        .permitAll()
//                )
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers("/logout") // Excluir CSRF para la URL de logout
//                );

        return http.build();
    }

}
