package com.myservice.portfolioservice.models;

public class UserDto {
    private Integer userdto_id;

    private String username;

    private String token;

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserdto_id(Integer id) {
        this.userdto_id = id;
    }

    public Integer getUserdto_id() {
        return userdto_id;
    }
}
