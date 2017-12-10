package com.labs.cyberclub.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tickets", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Ticket {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Название билета не должно быть пустым.")
    private String name;

    @NotNull(message = "Введите цену.")
    @Min(value = 0, message = "Цена должна быть больше нуля.")
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Ticket() {
    }

    public Ticket(String name, int price, User user) {
        this.name = name;
        this.price = price;
        this.user = user;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
