package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.models.Character;
import summerProject.demo.services.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/api/table/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;
    @GetMapping("/")
    List<CharacterDTO> all(){
        return characterService.getAllCharacters();
    }
}
