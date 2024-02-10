package edu.eci.ieti.ProyectoIntegrador.repository;

public class User {

    private final String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(UserDTO userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(UserDTO userDto) {
        this.name = userDto.getName();
    }
}