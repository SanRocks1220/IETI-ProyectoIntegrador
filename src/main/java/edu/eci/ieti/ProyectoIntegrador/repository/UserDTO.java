package edu.eci.ieti.ProyectoIntegrador.repository;

public class UserDTO {
    private final String name;
    private final String id;

    public UserDTO() {
        this.name = "";
        this.id = "";
    }

    public UserDTO(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return id;
    }
}
