package br.oo.alexandria.library;

public class User {

    protected int id;
    protected static int lastId = 0;
    protected String name;
    protected String phone;
    protected String email;
    
    User(){}
    
    User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId() {
        id = lastId++;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
