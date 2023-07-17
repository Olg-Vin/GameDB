package summerProject.demo.services;

import summerProject.demo.dtos.GameLocationDTO;

import java.util.List;
import java.util.Optional;

public interface GameLocationService<ID> {
    void save(GameLocationDTO gameLocationDTO);
    GameLocationDTO saveAndGet(GameLocationDTO gameLocationDTO);//    for foreign key

    Optional<GameLocationDTO> get(ID id);
    List<GameLocationDTO> getAll();

    void update(GameLocationDTO gameLocationDTO);
    void delete(ID id);
}
