package ro.alexandru.footballteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String name;

    @Setter
    @Getter
    @Column(nullable = false)
    private String league;

    @Setter
    @Getter
    @Column(nullable = false)
    private String stadium;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDate founded;

    @OneToMany(mappedBy="team")
    private List<Player> roster;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
        this.name = "";
        this.founded = LocalDate.now();
        this.league = "";
        this.stadium = "";
    }


    // getters and setters

}