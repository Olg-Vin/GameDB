package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacterDTO;
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
    public List<GameLocationDTO> getAllGameLocation() {
        return gameLocationRepository.findAll().stream().map((s) -> modelMapper.map(s, GameLocationDTO.class)).toList();
    }
}
