package ro.alexandru.footballteam.service;

import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.model.Jucator;

import java.util.List;

@Service
public interface JucatorService {
    public abstract void save(Jucator jucator);

    public abstract void delete(Jucator jucator);

    public abstract void update(Jucator jucator);

    public abstract Jucator getById(Long id);

    public abstract Jucator loadByName(String name);

    public abstract Jucator loadByTeamId(Long id);

    public abstract int countByTeamId(Long id);

    public abstract List<Jucator> getAllJucatoriByTeamId(Long id);
}
