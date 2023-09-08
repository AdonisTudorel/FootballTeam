package ro.alexandru.footballteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.alexandru.footballteam.model.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    Stadium findByName(String name);
}
