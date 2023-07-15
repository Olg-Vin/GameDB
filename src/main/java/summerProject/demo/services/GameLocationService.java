package summerProject.demo.services;

import summerProject.demo.dtos.GameLocationDTO;

import java.util.List;

public interface GameLocationService<ID> {
    void save(GameLocationDTO gameLocationDTO);
    GameLocationDTO saveAndGet(GameLocationDTO gameLocationDTO);//    for foreign key

    GameLocationDTO get(ID id);
    List<GameLocationDTO> getAll();

    void update(GameLocationDTO gameLocationDTO);
    void delete(ID id);
}
