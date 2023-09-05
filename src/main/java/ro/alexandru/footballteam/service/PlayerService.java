package ro.alexandru.footballteam.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ro.alexandru.footballteam.dto.PlayerDto;
import ro.alexandru.footballteam.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService extends UserDetailsService {


    public abstract void save(PlayerDto user);

    List<Player> getAll();

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}