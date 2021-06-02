package spring.softunimusicdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring.softunimusicdb.service.impl.MusicDBUserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    private final MusicDBUserService musicDBUserService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(MusicDBUserService musicDBUserService, PasswordEncoder passwordEncoder) {
        this.musicDBUserService = musicDBUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // allow access to static resources to anyone
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/img/**").permitAll()
                // allow access to index, user login and reg to anyone
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                // protect all other pages
        .antMatchers("/**").authenticated()
//                .anyRequest().authenticated()
        .and()
                // configure login with HTML form
                .formLogin()
                // our login page will be served by the controller with mapping /users/login
                .loginPage("/users/login")
                // the name of the username input field in OUR login form is username (optional)
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) // "username"
                // the name of the password input field in OUR login form is password (optional)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                // on login success redirect here
                .defaultSuccessUrl("/home")
                // on login failure redirect here
                .failureForwardUrl("/users/login-error")
        .and()
                // which endpoint performs logout, (should be POST request!!!)
            .logout()
            .logoutUrl("/logout")
                // where to land after logout
            .logoutSuccessUrl("/")
                // remove session from the server
            .invalidateHttpSession(true)
                // delete the session cookie
            .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(musicDBUserService)
                .passwordEncoder(passwordEncoder);
    }
}
