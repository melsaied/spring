package com.cloudtech.spring.configuration;

import com.cloudtech.spring.model.Authority;
import com.cloudtech.spring.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ApplicationUserDetails implements UserDetails {
    private long id;
    private String password;
    private String username;
    private Collection<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public ApplicationUserDetails(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.authorities =
                user.getAuthorities().stream()
                        .map(Authority::getAuthority)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toCollection(ArrayList::new));
        this.accountNonExpired = user.isAccountNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.enabled = user.isEnabled();
    }

    public ApplicationUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}