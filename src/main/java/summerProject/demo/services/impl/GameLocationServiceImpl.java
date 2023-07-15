package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.GameLocation;
import summerProject.demo.repositories.GameLocationRepository;
import summerProject.demo.services.GameLocationService;

import java.util.List;

@Service
public class GameLocationServiceImpl implements GameLocationService<String> {

    @Autowired
    private GameLocationRepository gameLocationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(GameLocationDTO gameLocationDTO) {
        gameLocationRepository.save(modelMapper.map(gameLocationDTO, GameLocation.class));
    }

    @Override
    public GameLocationDTO saveAndGet(GameLocationDTO gameLocationDTO) {
        GameLocation c = modelMapper.map(gameLocationDTO, GameLocation.class);
        return modelMapper.map(gameLocationRepository.save(c), GameLocationDTO.class);
    }

    @Override
    public GameLocationDTO get(String s) {
        return modelMapper.map(gameLocationRepository.findById(s), GameLocationDTO.class);
    }

    @Override
    public List<GameLocationDTO> getAll() {
        return gameLocationRepository.findAll().
                stream().map((s)->modelMapper.map(s, GameLocationDTO.class)).toList();
    }

    @Override
    public void update(GameLocationDTO gameLocationDTO) {
        gameLocationRepository.save(modelMapper.map(gameLocationDTO, GameLocation.class));
    }

    @Override
    public void delete(String s) {
        gameLocationRepository.deleteById(s);
    }
}
