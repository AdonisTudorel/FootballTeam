package ro.alexandru.footballteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Setter
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
    private LocalDate founded;

    @Setter
    @Getter
    @Column(nullable = false)
    private String details;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "stadium_id", referencedColumnName = "id")
    private Stadium stadium;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
        this.name = "";
        this.founded = LocalDate.now();
        this.league = "";
    }

}