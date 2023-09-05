package ro.alexandru.footballteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.dto.PlayerDto;
import ro.alexandru.footballteam.model.Player;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.alexandru.footballteam.enums.PlayerRole;
import ro.alexandru.footballteam.repository.PlayerRepository;

import java.util.Collection;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }

    @Override
    public void save(PlayerDto user) {
        Player newPlayer = new Player(
                user.getUsername(),
                bCryptPasswordEncoder.encode(user.getPassword()),
                PlayerRole.ROLE_USER
        );
        playerRepository.save(newPlayer);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                player.getUsername(),
                player.getPassword(),
                mapRoleToAuthorities(player.getRole())
        );
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(PlayerRole playerRole) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(playerRole.toString());
        return List.of(authority);
    }
}
