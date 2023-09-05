package ro.alexandru.footballteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.model.Team;
import ro.alexandru.footballteam.repository.TeamRepository;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }
}
