package ro.alexandru.footballteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alexandru.footballteam.model.Jucator;

import java.util.List;

public interface JucatorRepository extends JpaRepository<Jucator, Long> {
    Jucator findByName(String name);
    Jucator findByTeamId(Long id);
    int countByTeamId(Long id);
    List<Jucator> findAllByTeamId(Long id);
}
