package com.labs.cyberclub.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tournaments", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "name"}))
public class Tournament {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Название турнира не должно быть пустым.")
    private String name;

    @NotBlank(message = "Описание турнира не должно быть пустым.")
    private String description;

    @NotNull(message = "Введите призовой фонд.")
    @Min(value = 0, message = "Призовой фонд должен быть больше нуля.")
    private int prize;

    @NotNull(message = "Укажите необходимое количество игроков на команду.")
    @Min(value = 2, message = "Должно быть минимум два игрока в одной команде.")
    @Column(name = "players_per_team")
    private int playersPerTeam;

    @OneToMany(mappedBy = "tournament")
    private Set<Team> teams;

    public Tournament() {
    }

    public Tournament(String name, String description, int prize, int playersPerTeam, Set<Team> teams) {
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.playersPerTeam = playersPerTeam;
        this.teams = teams;
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
    public int getPrize() {
        return prize;
    }
    public void setPrize(int prize) {
        this.prize = prize;
    }
    public int getPlayersPerTeam() {
        return playersPerTeam;
    }
    public void setPlayersPerTeam(int playersPerTeam) {
        this.playersPerTeam = playersPerTeam;
    }
    public Set<Team> getTeams() {
        return teams;
    }
    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
