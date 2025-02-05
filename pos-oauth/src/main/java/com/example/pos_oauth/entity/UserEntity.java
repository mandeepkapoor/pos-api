package com.example.pos_oauth.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "user_entity")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;



    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<String> roles = Collections.emptyList();

    // Getters and setters omitted for brevity

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert the roles into GrantedAuthorities
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roles));
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public Set<String> getRoles() {
        return (Set<String>) this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
