package ro.alexandru.footballteam.dto;
import lombok.Getter;
import lombok.Setter;
import ro.alexandru.footballteam.enums.PlayerRole;

public class PlayerDto {
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private PlayerRole playerRole;

    public PlayerDto(){
    }
}
