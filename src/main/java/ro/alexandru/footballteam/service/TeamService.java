package ro.alexandru.footballteam.service;

import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.model.Team;

import java.util.List;

@Service
public interface TeamService {
    public List<Team> getAllTeams();
    public void save(Team team);

}