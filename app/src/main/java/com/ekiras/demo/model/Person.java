package com.ekiras.demo.model;

/**
 * Created by ekansh on 19/10/15.
 */
public class Person {

    private String name;
    private Integer image;
    private String email;
    private String desc;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
