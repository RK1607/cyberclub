package entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tournaments")
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

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<Team> teams;

    public Tournament() {
    }

    public Tournament(String name, String description, int prize, Set<Team> teams) {
        this.name = name;
        this.description = description;
        this.prize = prize;
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
