package summerProject.demo.services;

import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.dtos.QuestDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService<ID> {
    void save(ItemDTO itemDTO);
    ItemDTO saveAndGet(ItemDTO itemDTO);//    for foreign key

    Optional<ItemDTO> get(ID id);
    List<ItemDTO> getAll();

    void update(ItemDTO itemDTO);
    void delete(ID id);

    CharacteristicDTO saveAndGetCharacteristic(CharacteristicDTO characteristicDTO);

    List<QuestDTO> findAllItems(String itemName);
    List<CharacteristicDTO> findAllCharacteristics(String questName);
}
