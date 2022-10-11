package com.CursoPlatziFundamentos.SprontBoot.fundamentos.dto;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String name;
    private LocalDate fecha;

    public UserDTO(Long id, String name, LocalDate fecha) {
        this.id = id;
        this.name = name;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
