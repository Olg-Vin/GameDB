package summerProject.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.models.GameLocation;
import summerProject.demo.repositories.CharacterRepository;
import summerProject.demo.services.CharacterService;
import summerProject.demo.services.CharacteristicService;
import summerProject.demo.services.ItemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
//    todo make initialize data
    @Autowired
    private CharacterService characterService;
    @Autowired
    private CharacteristicService characteristicService;
    @Autowired
    private ItemService itemService;
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
        CharacteristicDTO characteristicDTO = new CharacteristicDTO(0,2,3,4,5,6,7);
        characteristicDTO = characteristicService.saveAndGet(characteristicDTO);

        List<CharacterDTO> characterDTOList = new ArrayList<>();
        String[] names = {"will", "gin", "tim", "tom", "rom"};
        for (String s:names){
            characterDTOList.add(new CharacterDTO(s, 1, 1, gameLocationDTO, characteristicDTO));
        }

        itemService.save(new ItemDTO("item one", characteristicDTO, 2, "hyi"));
        characterService.saveCharacter(new CharacterDTO("tem", 1, 1,
                gameLocationDTO, characteristicDTO));

    }
    private void printData() throws Exception{
        characterService.printAllCharacters();
    }
}
