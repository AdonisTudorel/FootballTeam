package ro.alexandru.footballteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
public class Stadium {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = true)
    private String country;

    @Getter
    @Setter
    @Column(nullable = true)
    private String city;

    @Getter
    @Setter
    @Column(nullable = true)
    private int capacity;

    public Stadium(String Name, String Country, String City, int Capacity) {
        this.name = Name;
        this.country = Country;
        this.city = City;
        this.capacity = Capacity;
    }

    public Stadium() {
        this.name = "";
        this.country = "";
        this.city = "";
        this.capacity = 0;
    }
}
