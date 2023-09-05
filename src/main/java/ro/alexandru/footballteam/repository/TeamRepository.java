package ro.alexandru.footballteam.repository;

import ro.alexandru.footballteam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}