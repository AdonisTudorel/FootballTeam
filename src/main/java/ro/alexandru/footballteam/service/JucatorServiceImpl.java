package ro.alexandru.footballteam.service;

import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.model.Jucator;
import ro.alexandru.footballteam.repository.JucatorRepository;

import java.util.List;

@Service
public class JucatorServiceImpl implements JucatorService{

    private final JucatorRepository jucatorRepository;

    public JucatorServiceImpl(JucatorRepository jucatorRepository) {
        super();
        this.jucatorRepository = jucatorRepository;
    }

    @Override
    public void save(Jucator jucator) {
        Jucator newJucator = new Jucator();
        newJucator.setName(jucator.getName());
        newJucator.setLastname(jucator.getLastname());
        newJucator.setPosition(jucator.getPosition());
        newJucator.setAge(jucator.getAge());
        newJucator.setTeam(jucator.getTeam());

        jucatorRepository.save(jucator);
    }

    @Override
    public void delete(Jucator jucator) {
        jucatorRepository.delete(jucator);
    }

    @Override
    public void update(Jucator jucator) {
        jucatorRepository.save(jucator);
    }

    @Override
    public Jucator getById(Long id) {
        return jucatorRepository.findById(id).orElse(null);
    }

    @Override
    public Jucator loadByName(String name) {
        return jucatorRepository.findByName(name);
    }

    @Override
    public Jucator loadByTeamId(Long id) {
        return jucatorRepository.findByTeamId(id);
    }

    @Override
    public int countByTeamId(Long id) {
        return jucatorRepository.countByTeamId(id);
    }

    @Override
    public List<Jucator> getAllJucatoriByTeamId(Long id) {
        return jucatorRepository.findAllByTeamId(id);
    }

}
