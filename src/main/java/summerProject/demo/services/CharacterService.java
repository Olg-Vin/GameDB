package summerProject.demo.services;

import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.Characteristic;
import summerProject.demo.models.GameLocation;

import java.util.List;
import java.util.Optional;

public interface CharacterService<ID> {
    void save(CharacterDTO characterDTO);
    CharacterDTO saveAndGet(CharacterDTO characterDTO);//    for foreign key
//    void saveAndGet(CharacterDTO characterDTO);

    Optional<CharacterDTO> get(ID id);
    List<CharacterDTO> getAll();

    void update(CharacterDTO characterDTO);
    void delete(ID id);

    CharacteristicDTO getDefCharacteristic();
    GameLocationDTO getDefGameLocation();
}
