package com.labs.cyberclub.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "email", "nickname"}))
public class User {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Укажите email.")
    @Email(message = "Пожалуйста, введите корректный email.")
    private String email;

    @NotBlank(message = "Укажите пароль.")
    @Length(min = 8, message = "Пароль должен содержать не менее 8 символов.")
    private String password;

    @NotBlank(message = "Укажите никнейм.")
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

    public User() { }

    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public User(String email, String password, String nickname, Team team) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.team = team;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
}
