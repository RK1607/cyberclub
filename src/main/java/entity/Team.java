package entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Укажите название команды")
    @Length(min = 2, message = "Название должно быть не меньше 2 символов.")
    private String name;

    @NotBlank(message = "Расскажите нам о себе!")
    @Length(min = 20, message = "Опишите себя не менее, чем 20 символами.")
    private String description;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<User> players;

    public Team() {
    }

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
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
}
