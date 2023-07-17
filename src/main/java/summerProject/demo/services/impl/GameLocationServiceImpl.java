package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.GameLocation;
import summerProject.demo.repositories.CharacterRepository;
import summerProject.demo.repositories.GameLocationRepository;
import summerProject.demo.repositories.QuestRepository;
import summerProject.demo.services.GameLocationService;

import java.util.List;
import java.util.Optional;

@Service
public class GameLocationServiceImpl implements GameLocationService<String> {

    @Autowired
    private GameLocationRepository gameLocationRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private QuestRepository questRepository;
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
    public Optional<GameLocationDTO> get(String s) {
        return Optional.ofNullable(modelMapper.map(gameLocationRepository.findById(s), GameLocationDTO.class));
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
//        questRepository.deleteRewardLogByLocationName(s);
//        questRepository.deleteQuestByLocationName(s);
//        characterRepository.deleteCharacterByLocationName(s);
        gameLocationRepository.deleteById(s);
    }
}
