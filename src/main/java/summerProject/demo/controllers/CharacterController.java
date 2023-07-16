package summerProject.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.services.CharacterService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    List<CharacterDTO> getAll() {
        return characterService.getAll();
    }

    @GetMapping("/{id}")
    CharacterDTO getOne(@PathVariable String id) {
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

    //    @DeleteMapping("/delete/{id}")
//    void deleteCharacter(@PathVariable String id) {
//        characterService.delete(id);
//    }
    @DeleteMapping("/delete")
    void deleteCharacter(@RequestBody String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Преобразование JSON в JsonNode
            JsonNode rootNode = objectMapper.readTree(json);
            // Получение значения по ключу
            String id = rootNode.get("key").asText();
            System.out.println(id);
            characterService.delete(id);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
