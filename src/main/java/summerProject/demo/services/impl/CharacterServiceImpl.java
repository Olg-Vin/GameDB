package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.models.Character;
import summerProject.demo.repositories.CharacterRepository;
import summerProject.demo.services.CharacterService;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService<String> {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CharacterDTO characterDTO) {
        characterRepository.save(modelMapper.map(characterDTO, Character.class));
    }

    @Override
    public CharacterDTO saveAndGet(CharacterDTO characterDTO) {
        Character c = modelMapper.map(characterDTO, Character.class);
        return modelMapper.map(characterRepository.save(c), CharacterDTO.class);
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
}
