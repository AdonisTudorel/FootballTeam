package ro.alexandru.footballteam.dto;
import lombok.Getter;
import ro.alexandru.footballteam.enums.PlayerRole;

public class PlayerDto {
    @Getter
    private String username;
    private String password;

    public PlayerDto(){
    }

    public void setUsername(String username){
        this.username = username;
    }

    public CharSequence getPassword() {
        return password;
    }
    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    public void setRole(PlayerRole role) {
    }

}
