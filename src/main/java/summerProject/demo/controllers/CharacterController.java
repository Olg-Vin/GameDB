package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.services.CharacterService;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@RestController
@RequestMapping("/api/table/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;
    @GetMapping("/")
    List<CharacterDTO> getAll(){
        return characterService.getAll();
    }
    @GetMapping("/{id}")
    CharacterDTO getOne(@PathVariable String id){
        return characterService.get(id);
    }

    @PostMapping("/add")
    CharacterDTO newCharacter(@RequestBody CharacterDTO newCharacterDTO) {
        return characterService.saveAndGet(newCharacterDTO);
    }

    @PostMapping("/update")
    CharacterDTO updateCharacter(@RequestBody CharacterDTO newCharacterDTO) {
        return characterService.saveAndGet(newCharacterDTO);
    }
    @DeleteMapping("/delete/{id}")
    void deleteCharacter(@PathVariable String id) {
        characterService.delete(id);
    }

}
