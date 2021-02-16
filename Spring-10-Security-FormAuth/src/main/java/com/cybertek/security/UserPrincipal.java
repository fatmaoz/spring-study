package com.cybertek.security;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {//Spring security class
    //Eger Database den authentication yapacaksak USerDetails class i kullanmak zorundayiz

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {//spring security autherizzation ve permission icin
        //bu methodu kontrol ediyor
        //permission ve rolleri assign etmek icin kullaniliyor
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //Extract list of permissions
        user.getPermissionList().forEach(p->{
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorityList.add(authority);
        });

        //Extract list of roles
        user.getRoleList().forEach(r->{
            GrantedAuthority authority = new SimpleGrantedAuthority(r);
            authorityList.add(authority);
        });
        return authorityList;

        //authority list hem authorities i hem de rolleri tutuyor

    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return this.user.getActive()==1;
    }
}
