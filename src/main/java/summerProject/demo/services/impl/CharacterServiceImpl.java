package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.models.*;
import summerProject.demo.models.Character;
import summerProject.demo.models.compositeKeys.InventoryLogKeys;
import summerProject.demo.models.compositeKeys.QuestLogKeys;
import summerProject.demo.repositories.*;
import summerProject.demo.services.CharacterService;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService<String> {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private GameLocationRepository gameLocationRepository;
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private CharacteristicRepository characteristicRepository;
    @Autowired
    private QuestLogRepository questLogRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InventoryLogRepository inventoryLogRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CharacterDTO characterDTO) {
        characterRepository.save(modelMapper.map(characterDTO, Character.class));
    }
// create new character, add.text default location and start characteristics
    @Override
    public CharacterDTO saveAndGet(CharacterDTO characterDTO) {
        characterDTO.setLevel(1);
        characterDTO.setCurrentLocation(getDefGameLocation());
        characterDTO.setPowerRate(getDefCharacteristic());
        Character c = modelMapper.map(characterDTO, Character.class);
        return modelMapper.map(characterRepository.save(c), CharacterDTO.class);
    }
    @Override
    public Optional<CharacterDTO> get(String s) {
        return Optional.ofNullable(modelMapper.map(characterRepository.findById(s), CharacterDTO.class));
    }
    @Override
    public List<CharacterDTO> getAll() {
        return characterRepository.findAll().
                stream().map((s)->modelMapper.map(s, CharacterDTO.class)).toList();
    }
    @Override
    public void update(CharacterDTO characterDTO) {
        characterRepository.save(modelMapper.map(characterDTO, Character.class));
    }
    @Override
    public void delete(String s) {
        characterRepository.deleteById(s);
    }

    @Override
    public CharacteristicDTO getDefCharacteristic() {
        return modelMapper.map(characteristicRepository.save(
                new Characteristic(0,50,150,50,50,50,50)), CharacteristicDTO.class);
    }

    @Override
    public GameLocationDTO getDefGameLocation() {
        return modelMapper.map(gameLocationRepository.findById("default"), GameLocationDTO.class);
    }

    @Override
    public void addQuest(String characterName, String questName) {
        Quest quest = questRepository.findById(questName).orElseThrow();
        Character character = characterRepository.findById(characterName).orElseThrow();
//        create composite key
        QuestLogKeys key = new QuestLogKeys();
        key.setQuestName(questName);
        key.setCharacterName(characterName);
//          create obj
        QuestLog questLog = new QuestLog(key);
        questLog.setQuest(quest);
        questLog.setCharacter(character);
        questLogRepository.save(questLog);
    }

    @Override
    public void addItem(String characterName, String itemName) {
        Character character = characterRepository.findById(characterName).orElseThrow();
        Item item = itemRepository.findById(itemName).orElseThrow();
//        create composite key
        InventoryLogKeys key = new InventoryLogKeys();
        key.setCharacterName(characterName);
        key.setItemName(itemName);
        if (inventoryLogRepository.findById(key).isEmpty()){
//          create obj
            InventoryLog inventoryLog = new InventoryLog(key, 1);
            inventoryLog.setCharacter(character);
            inventoryLog.setItem(item);
            inventoryLogRepository.save(inventoryLog);
        }
        else {
            InventoryLog inventoryLog = inventoryLogRepository.findById(key).orElseThrow();
            inventoryLog.setCount(inventoryLog.getCount()+1);
            inventoryLogRepository.save(inventoryLog);
        }
    }

    @Override
    public List<QuestDTO> findQuestContent(String playerName) {
        return characterRepository.findQuestContentByPlayerName(playerName).stream().map((element)->
            modelMapper.map(element, QuestDTO.class)).toList();
    }

    @Override
    public List<CharacterDTO> findCharacterByClass(int characterClass) {
        return characterRepository.findCharacterByCharacterClass(characterClass).stream().map((element)->
                modelMapper.map(element, CharacterDTO.class)).toList();
    }
}
