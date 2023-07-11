package com.terzocloud.employeez.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserDetailsDto implements UserDetails {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate joinedOn;
    private String designation;
    private String address;
    private String password;
    private Long mobile;
    private String photoUrl;
    private LeaveInfo leaveInfo;
    private List<Leave> leaves;
    private Department department;
    private int reportTo;
    private List<Role> roles;
    private List<GrantedAuthority> authorities;
    private Boolean active;

    public UserDetailsDto(Employee employee){
        this.id = employee.getId();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.email = employee.getEmail();
        this.dateOfBirth = employee.getDateOfBirth();
        this.joinedOn = employee.getJoinedOn();
        this.designation = employee.getDesignation();
        this.address = employee.getAddress();
        this.password = employee.getPassword();
        this.mobile = employee.getMobile();
        this.photoUrl = employee.getPhotoUrl();
        this.leaveInfo = employee.getLeaveInfo();
        this.leaves = employee.getLeaves();
        this.department = employee.getDepartment();
        this.roles = employee.getRoles();
        List<GrantedAuthority> authoritiesList = new ArrayList<>();
        authoritiesList = IntStream.range(0, roles.size())
                .mapToObj(i -> roles.get(i).getName())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.authorities = authoritiesList;
        this.active = true;

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
        return email;
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
        return active;
    }
}
