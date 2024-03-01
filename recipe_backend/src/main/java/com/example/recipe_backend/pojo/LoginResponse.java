package com.example.recipe_backend.pojo;

import com.example.recipe_backend.entity.ApplicationUser;

public class LoginResponse {
    private ApplicationUser applicationUser;
    private String jwt;

    public LoginResponse() {
        super();
    }

    public LoginResponse(ApplicationUser applicationUser, String jwt) {
        this.applicationUser = applicationUser;
        this.jwt = jwt;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
