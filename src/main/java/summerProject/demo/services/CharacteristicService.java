package summerProject.demo.services;

import summerProject.demo.dtos.CharacteristicDTO;

import java.util.List;

public interface CharacteristicService<ID> {
    void save(CharacteristicDTO characteristicDTO);
    CharacteristicDTO saveAndGet(CharacteristicDTO characteristicDTO);//    for foreign key

    CharacteristicDTO get(ID id);
    List<CharacteristicDTO> getAll();

    void update(CharacteristicDTO characteristicDTO);
    void delete(ID id);
}
