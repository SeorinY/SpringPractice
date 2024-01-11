package seorin.org.practice2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity  // SpringSecurity Filter (아래의 SecurityConfig) 가 Filter Chain 에 등록됨!
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 다음 경로에 대한 요청은 인증 없이 접근을 허용하도록 설정한다.
//		http.authorizeRequests().antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**").permitAll();

        // 위에서 언급한 경로 외에는 모두 인증을 거치도록 설정한다.
//		http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().anyRequest().permitAll();

        /*
        http
            .authorizeRequests()
            .antMatchers("/users/**").authenticated() // 로그인한 사람
            .antMatchers("/managers/**")
            .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") // 로그인한 사람 + 역할
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // 로그인한 사람 + 역할
            .anyRequest().permitAll();  // 위 세개가 router 가 아니면 모두 승인
         */

        // 시큐리티가 제공하는 기본 로그인 화면은 CSRF 토큰을 무조건 전달한다.
        // 하지만 사용자 정의 로그인 화면에서는 CSRF 토큰을 전달하지 않는다.
        http.csrf().disable()
            .cors().disable();

        // 사용자가 만든 로그인 화면을 띄운다.
//		http.formLogin().loginPage("/auth/login");
        http.formLogin().disable();

        // 로그아웃 설정
//		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
    }
}
