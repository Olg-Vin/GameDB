package summerProject.demo.services;

import summerProject.demo.dtos.CharacterDTO;

import java.util.List;

public interface CharacterService<ID> {
    void save(CharacterDTO characterDTO);
    CharacterDTO saveAndGet(CharacterDTO characterDTO);//    for foreign key

    CharacterDTO get(ID id);
    List<CharacterDTO> getAll();

    void update(CharacterDTO characterDTO);
    void delete(ID id);
}
