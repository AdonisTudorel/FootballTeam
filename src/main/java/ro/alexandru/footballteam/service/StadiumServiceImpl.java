package ro.alexandru.footballteam.service;

import org.springframework.stereotype.Service;
import ro.alexandru.footballteam.dto.StadiumDto;
import ro.alexandru.footballteam.model.Stadium;
import ro.alexandru.footballteam.repository.StadiumRepository;

import java.util.List;

import static org.aspectj.runtime.internal.Conversions.intValue;

@Service
public class StadiumServiceImpl implements StadiumService{
    private final StadiumRepository stadiumRepository;
    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        super();
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public void save(Stadium stadiumDto){
        Stadium stadium = new Stadium();
        stadium.setName(stadiumDto.getName());
        stadium.setCountry(stadiumDto.getCountry());
        stadium.setCity(stadiumDto.getCity());
        stadium.setCapacity(stadiumDto.getCapacity());
        stadiumRepository.save(stadium);
    }

    @Override
    public List<Stadium> getAll() {
        return stadiumRepository.findAll();
    }

    @Override
    public Stadium getById(Long id) {
        return stadiumRepository.findById(id).orElseThrow();
    }

    @Override
    public Stadium loadByName(String name) {
        return stadiumRepository.findByName(name);
    }
}
