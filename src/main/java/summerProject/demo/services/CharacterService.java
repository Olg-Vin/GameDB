package summerProject.demo.services;

import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.GameLocation;

import java.util.List;

public interface CharacterService {

    void printAllCharacters();
    void saveAllCharacter(List<CharacterDTO> characterDTOList);



    void saveAllLocation(GameLocationDTO gameLocationDTO);
}
