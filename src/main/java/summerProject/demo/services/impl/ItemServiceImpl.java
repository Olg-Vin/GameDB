package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.models.Characteristic;
import summerProject.demo.models.Item;
import summerProject.demo.repositories.CharacteristicRepository;
import summerProject.demo.repositories.ItemRepository;
import summerProject.demo.services.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService<String> {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CharacteristicRepository characteristicRepository;

    @Override
    public void save(ItemDTO itemDTO) {
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public ItemDTO saveAndGet(ItemDTO itemDTO) {
        Item c = modelMapper.map(itemDTO, Item.class);
        return modelMapper.map(itemRepository.save(c), ItemDTO.class);
    }

    @Override
    public ItemDTO get(String s) {
        return modelMapper.map(itemRepository.findById(s), ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getAll() {
        return itemRepository.findAll().
                stream().map((s)->modelMapper.map(s, ItemDTO.class)).toList();
    }

    @Override
    public void update(ItemDTO itemDTO) {
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void delete(String s) {
        itemRepository.deleteById(s);
    }

    @Override
    public CharacteristicDTO saveAndGetCharacteristic(CharacteristicDTO characteristicDTO) {
        Characteristic c = modelMapper.map(characteristicDTO, Characteristic.class);
        return modelMapper.map(characteristicRepository.save(c), CharacteristicDTO.class);
    }

    @Override
    public List<QuestDTO> findAllItems(String questName) {
        return itemRepository.findAllItemsByQuestName(questName).stream().map((element)->
                modelMapper.map(element, QuestDTO.class)).toList();
    }

    @Override
    public List<CharacteristicDTO> findAllCharacteristics(String questName) {
        return itemRepository.findAllCharacteristicsForItemByQuestName(questName).stream().map((element)->
                modelMapper.map(element, CharacteristicDTO.class)).toList();
    }
}
