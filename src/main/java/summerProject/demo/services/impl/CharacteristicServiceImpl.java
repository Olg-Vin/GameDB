package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.models.Characteristic;
import summerProject.demo.repositories.CharacteristicRepository;
import summerProject.demo.services.CharacteristicService;

import java.util.List;

@Service
public class CharacteristicServiceImpl implements CharacteristicService<Integer> {
    @Autowired
    private CharacteristicRepository characteristicRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CharacteristicDTO characteristicDTO) {
        characteristicRepository.save(modelMapper.map(characteristicDTO, Characteristic.class));
    }

    @Override
    public CharacteristicDTO saveAndGet(CharacteristicDTO characteristicDTO) {
        Characteristic c = modelMapper.map(characteristicDTO, Characteristic.class);
        return modelMapper.map(characteristicRepository.save(c), CharacteristicDTO.class);
    }

    @Override
    public CharacteristicDTO get(Integer id) {
        return modelMapper.map(characteristicRepository.findById(id), CharacteristicDTO.class);
    }

    // todo
    @Override
    public List<CharacteristicDTO> getAll() {
        return characteristicRepository.findAll().
                stream().map((s)->modelMapper.map(s, CharacteristicDTO.class)).toList();
    }

    @Override
    public void update(CharacteristicDTO characteristicDTO) {
        characteristicRepository.save(modelMapper.map(characteristicDTO, Characteristic.class));
    }
    @Override
    public void delete(Integer id) {
        characteristicRepository.deleteById(id);
    }
}
