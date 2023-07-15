package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.Character;
import summerProject.demo.models.GameLocation;
import summerProject.demo.repositories.CharacterRepository;
import summerProject.demo.repositories.GameLocationRepository;
import summerProject.demo.services.CharacterService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService<String> {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GameLocationRepository gameLocationRepository;

    @Override
    public void printAllCharacters() {
        List<CharacterDTO> characterDTOList =
                characterRepository.findAll().stream().map((s) -> modelMapper.map(s, CharacterDTO.class)).toList();
        for(CharacterDTO c:characterDTOList){
            System.out.println(c);
        }
    }

    @Override
    public void saveCharacter(CharacterDTO characterDTO) {
        characterRepository.save(modelMapper.map(characterDTO, Character.class));
    }

    @Override
    public void saveAllCharacter(List<CharacterDTO> characterDTOList) {
        characterRepository.saveAll(characterDTOList.stream().map((s) -> modelMapper.map(s, Character.class)).toList());
//        for (CharacterDTO c: characterDTOList){
//            characterRepository.save(modelMapper.map(c, Character.class));
//        }
    }

    @Override
    public List<CharacterDTO> getAllCharacters() {
        return characterRepository.findAll().stream().map((s) -> modelMapper.map(s, CharacterDTO.class)).toList();
    }

    @Override
    public void saveAllLocation(GameLocationDTO gameLocationDTO) {
        gameLocationRepository.save(modelMapper.map(gameLocationDTO, GameLocation.class));
    }
}
