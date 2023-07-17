package summerProject.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import summerProject.demo.dtos.*;
import summerProject.demo.services.*;

import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
//    todo make initialize data
    @Autowired
    private CharacterService characterService;
    @Autowired
    private GameLocationService gameLocationService;
    @Autowired
    private QuestService questService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(String... args) throws Exception {
        addData();
        printData();
//        characterService.findQuestContent("will");
//        System.out.println(info.get(0));
    }
    private void addData() throws Exception{
        String[] characterNames = {"will", "gin", "tim", "tom", "rom"};
        String[] locationNames = {"storm wind", "magician", "carazhan", "black pink", "nord school"};
        String[] itemNames = {"stone", "stick", "weapon", "back", "scrin"};
        String[] questNames = {"defet", "amount", "collect saver", "escape the king", "the great idea"};

        GameLocationDTO gameLocationDTO = new GameLocationDTO("default", "legend", 2);
        gameLocationService.save(gameLocationDTO);

        for (int i = 0; i < characterNames.length; i++){
            gameLocationService.save(new GameLocationDTO(locationNames[i], "never die", 1));
            questService.save(new QuestDTO(questNames[i], "*optional*",
                    gameLocationDTO, gameLocationDTO, "fox"));
            itemService.save(new ItemDTO(itemNames[i],
                    itemService.saveAndGetCharacteristic(new CharacteristicDTO(0,1,2,3,4,5,6)),
                    2, "wow!"));
            characterService.saveAndGet(new CharacterDTO(characterNames[i], 1));
        }
        questService.addItem("defet", "stone", 20);
        questService.addItem("amount", "stone", 20);
        questService.addItem("collect saver", "stone", 20);
        characterService.addQuest("will", "amount");
        characterService.addQuest("will", "defet");
        characterService.addQuest("will", "the great idea");
        characterService.addItem("will", "stone");
    }
    private void printData() throws Exception{
        List<CharacterDTO> characterDTOList = characterService.getAll();
        for (CharacterDTO c:characterDTOList){
            System.out.println(c.toString());
//            GameLocationDTO location = c.getCurrentLocation();
//            System.out.println("Character Location: " + location.getName());
        }
    }
}
