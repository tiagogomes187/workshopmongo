package com.devsuperior.workshopmongo.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collation = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    public List<Post> posts = new ArrayList<>();

    
    public User() {
    }

    public User(String id, String name, String email) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
