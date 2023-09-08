package ro.alexandru.footballteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ro.alexandru.footballteam.enums.PlayerRole;

@Entity
public class Player {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String username;

    @Setter
    @Getter
    @Column(nullable = false)
    private String password;

    @Setter
    @Getter
    @Column(nullable = false)
    private PlayerRole playerRole;

    public Player(String username, String encode, PlayerRole playerRole) {
        this.username = username;
        this.password = encode;
        this.playerRole = playerRole;
    }

    public Player() {;
        this.username = "";
        this.password = "";
        this.playerRole = PlayerRole.ROLE_USER;
    }

    public PlayerRole getRole() {
        return playerRole;
    }

    // getters and setters

}