package ro.alexandru.footballteam.repository;

import ro.alexandru.footballteam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByNameContainingIgnoreCase(String query);
}