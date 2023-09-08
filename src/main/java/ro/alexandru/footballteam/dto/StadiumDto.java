package ro.alexandru.footballteam.dto;

import lombok.Getter;
import lombok.Setter;

public class StadiumDto {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private Number capacity;
}
