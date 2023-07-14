package summerProject.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.models.GameLocation;
import summerProject.demo.repositories.CharacterRepository;
import summerProject.demo.services.CharacterService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
//    todo make initialize data
    @Autowired
    private CharacterService characterService;
//    @Autowired
//    private CharacterRepository characterRepository;
//    @Autowired
//    private ModelMapper modelMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("__________________________________________________________________________________________");
        addData();
        printData();
    }
    private void addData() throws Exception{
        GameLocationDTO gameLocationDTO = new GameLocationDTO("loc", "legend", 2);
        characterService.saveAllLocation(gameLocationDTO);
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        String[] names = {"will", "gin", "tim", "tom", "rom"};
        for (String s:names){
            characterDTOList.add(new CharacterDTO(s, 1, 1, gameLocationDTO, 1));
        }
        characterService.saveAllCharacter(characterDTOList);
//        characterRepository.saveAll(characterDTOList.stream().map((c) -> modelMapper.map(c, Character.class)).toList());

    }
    private void printData() throws Exception{
        characterService.printAllCharacters();
    }
}
