package com.labs.cyberclub.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "name"}))
public class Team {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Укажите название команды.")
    @Length(min = 2, message = "Название должно быть не меньше 2 символов.")
    private String name;

    @NotBlank(message = "Расскажите нам о себе!")
    @Length(min = 20, message = "Опишите себя не менее, чем 20 символами.")
    private String description;

    @OneToMany(mappedBy = "team")
    private Set<User> players;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Team() {
    }

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Team(String name, String description, Set<User> players) {
        this.name = name;
        this.description = description;
        this.players = players;
    }

    public Team(String name, String description, Set<User> players, Tournament tournament) {
        this.name = name;
        this.description = description;
        this.players = players;
        this.tournament = tournament;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<User> getPlayers() {
        return players;
    }
    public void setPlayers(Set<User> players) {
        this.players = players;
    }
    public Tournament getTournament() {
        return tournament;
    }
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
