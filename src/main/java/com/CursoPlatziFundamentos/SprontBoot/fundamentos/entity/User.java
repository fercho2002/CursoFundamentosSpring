package com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    /*aca en el generationType.Auto cada vez que se cree un user va a generar un id automatico de 1,2,3,...*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_user",unique = true)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50,unique = true)
    private String email;

    @Column
    private LocalDate bithdate;


    /*aca en el mappedBy le estoy diciendo de donde lo voy a llamar y en este caso en la clase Post lo llame asi user con minuscula jaja */
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    /*este @JsonManagedReference es para que cuando llame esto desde un servicio rest no me genere ningun error  */
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String nombre, String email, LocalDate bithdate) {
        this.nombre = nombre;
        this.email = email;
        this.bithdate = bithdate;
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBithdate() {
        return bithdate;
    }

    public void setBithdate(LocalDate bithdate) {
        this.bithdate = bithdate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", bithdate=" + bithdate +
                ", posts=" + posts +
                '}';
    }
}
