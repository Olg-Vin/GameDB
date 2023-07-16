package summerProject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import summerProject.demo.dtos.*;
import summerProject.demo.services.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
//    todo make initialize data
    @Autowired
    private CharacterService characterService;
    @Autowired
    private CharacteristicService characteristicService;
    @Autowired
    private GameLocationService gameLocationService;
    @Autowired
    private QuestService questService;
    @Autowired
    private ItemService itemService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("__________________________________________________________________________________________");
        addData();
        printData();
    }
    private void addData() throws Exception{
        String[] characterNames = {"will", "gin", "tim", "tom", "rom"};
        String[] locationNames = {"storm wind", "magician", "carazhan", "black pink", "nord school"};
        String[] itemNames = {"stone", "stick", "weapon", "back", "scrin"};
        String[] questNames = {"defet", "amount", "collect saver", "escape the king", "the great idea"};

        GameLocationDTO gameLocationDTO = new GameLocationDTO("yandex", "legend", 2);
        gameLocationService.save(gameLocationDTO);

        for (int i = 0; i < characterNames.length; i++){
            gameLocationService.save(new GameLocationDTO(locationNames[i], "never die", 1));
            questService.save(new QuestDTO(questNames[i], "*optional*",
                    gameLocationDTO, gameLocationDTO, "fox"));
            itemService.save(new ItemDTO(itemNames[i],
                    characteristicService.saveAndGet(new CharacteristicDTO(0,1,2,3,4,5,6)),
                    2, "hyi"));
            characterService.saveAndGet(new CharacterDTO(characterNames[i], 1, 1
                    ));
        }
    }
    private void printData() throws Exception{
        List<CharacterDTO> characterDTOList = characterService.getAll();
        for (CharacterDTO c:characterDTOList){
            System.out.println(c.toString());
        }
    }
}
