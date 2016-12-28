package com.ssm.domain;

public class AuthGroup {
    private Integer id;

    private String name;

    public AuthGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthGroup() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}