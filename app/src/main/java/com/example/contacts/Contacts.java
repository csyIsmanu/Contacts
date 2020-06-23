package com.example.contacts;

public class Contacts {
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
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Contacts(){

    }
    public Contacts(Integer Id,String Name,String Phone,String Sex){

        id = Id;
        name = Name ;
        phone = Phone ;
        sex = Sex;

    }


    private Integer id ;
    private String name ;
    private String phone ;
    private String sex ;
}
