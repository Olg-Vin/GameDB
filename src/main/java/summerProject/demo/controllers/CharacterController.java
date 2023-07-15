package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return characterService.getAll();
    }

//    @PostMapping("/add")
//
//    @PostMapping("/update")
//
//    @DeleteMapping("/delete")
}
