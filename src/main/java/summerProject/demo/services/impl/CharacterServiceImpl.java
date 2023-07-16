package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.models.Character;
import summerProject.demo.models.Characteristic;
import summerProject.demo.models.GameLocation;
import summerProject.demo.repositories.CharacterRepository;
import summerProject.demo.repositories.CharacteristicRepository;
import summerProject.demo.repositories.GameLocationRepository;
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
    private CharacteristicRepository characteristicRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CharacterDTO characterDTO) {
        characterRepository.save(modelMapper.map(characterDTO, Character.class));
    }

    @Override
    public CharacterDTO saveAndGet(CharacterDTO characterDTO) {
        Character c = modelMapper.map(characterDTO, Character.class);
        Optional<GameLocation> g = gameLocationRepository.findById("yandex");
        System.out.println("!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
//        System.out.println(modelMapper.map(g, GameLocation.class));
        c.setCurrentLocation(modelMapper.map(g, GameLocation.class));
        c.setPowerRate(getDefCharacteristic());
//        System.out.println(g);
        return modelMapper.map(characterRepository.save(c), CharacterDTO.class);
//        return null;
    }


    @Override
    public CharacterDTO get(String s) {
        return modelMapper.map(characterRepository.findById(s), CharacterDTO.class);
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
    public Characteristic getDefCharacteristic() {
        return characteristicRepository.save(new Characteristic());
    }
}
