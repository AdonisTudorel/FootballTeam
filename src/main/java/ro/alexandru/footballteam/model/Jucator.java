package ro.alexandru.footballteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Jucator {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String lastname;

    @Setter
    @Getter
    private String position;

    @Setter
    @Getter
    private int age;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = true)
    private Team team;

    public Jucator(String name, String lastname, String position, int age) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.age = age;
    }

    public Jucator() {
        this.name = "";
        this.lastname = "";
        this.position = "";
        this.age = 0;
    }
}
