package com.ssm.domain.json;

import java.util.List;
import java.util.Map;

public class Menu {
    private Integer id;
    private String text;
    private String state;
    private Map<String,String> attributes;
    private Boolean checked;
    private List<Menu> children;

    public Menu(Integer id, String text, String state, Map<String,String> attributes, Boolean checked) {
        this.id = id;
        this.text = text;
        this.state = state;
        this.attributes = attributes;
        this.checked = checked;
    }

    public Menu() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", attributes=" + attributes +
                ", checked=" + checked +
                '}';
    }
}
