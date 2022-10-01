package com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity;


import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    /*este es el id de la entidad y en la linea de abajo genero uno aleatorio pero tambine puededo
    poner un in o string debajo de la etiqueta @id y esa tomara ese id de esta clase o entidad  y tambien se guarda el la variable private long id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_post",nullable = false,unique = true)
    private long id;

    @Column(name="descripcion",nullable = false,length = 400)
    private String description ;

    //con esta etiqueta estamos diciento que a esta entidad un user la puede llamar varias veces
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
