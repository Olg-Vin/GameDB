package summerProject.demo.services;

import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.Character;
import summerProject.demo.models.GameLocation;

import java.util.List;
import java.util.Optional;

public interface CharacterService<ID> {

    void printAllCharacters();
    void saveAllCharacter(List<CharacterDTO> characterDTOList);
    List<CharacterDTO> getAllCharacters();



    void saveAllLocation(GameLocationDTO gameLocationDTO);
}
