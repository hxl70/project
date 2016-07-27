package com.hxl.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/5/17.
 * Security 配置
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDecisionManager accessDecision;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index", "/login").permitAll()
                .anyRequest().authenticated()
                .accessDecisionManager(accessDecision)
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and().logout().logoutUrl("/logout").deleteCookies("remember-me").logoutSuccessUrl("/").permitAll()
                .and().rememberMe().key("whatsKey").rememberMeCookieName("remember-me").rememberMeParameter("rememberMe").userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
    }

    @Bean
    protected AccessDecisionManager accessDecision() {
        List<AccessDecisionVoter<?>> voters = new ArrayList<>();
        voters.add(new WebExpressionVoter()); //Voter which handles web authorisation decisions.
        voters.add(new AuthenticatedVoter()); //spring 认证 Voter
//        voters.add(new AdminVoter()); //自定义Voter
        voters.add(new RoleVoter()); //spring 角色 Voter
        return new AffirmativeBased(voters); //投票机制:所有弃权则通过.有同意则通过,没有赞成但是有反对则抛出异常
    }

}
