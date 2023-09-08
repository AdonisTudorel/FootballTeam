package ro.alexandru.footballteam.service;

import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.dto.StadiumDto;
import ro.alexandru.footballteam.model.Stadium;

import java.util.List;

@Service
public interface StadiumService {

    public abstract void save(Stadium stadium);

    List<Stadium> getAll();

    Stadium getById(Long id);

    Stadium loadByName(String name);
}
