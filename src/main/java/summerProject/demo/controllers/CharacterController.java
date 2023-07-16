package summerProject.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.exceptions.AppError;
import summerProject.demo.services.CharacterService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/table/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/")
    List<CharacterDTO> getAll() {
        return characterService.getAll();
    }
//    todo
    @GetMapping("/{id}")
    ResponseEntity<?> getOne(@PathVariable String id) throws Throwable {
       Optional<CharacterDTO> characterDTO = characterService.get(id);
        if (characterDTO.isEmpty()) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Product with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(characterDTO);
    }

    @PostMapping("/add")
    CharacterDTO newCharacter(@RequestBody CharacterDTO newCharacterDTO) {
        System.out.println(newCharacterDTO);
        return characterService.saveAndGet(newCharacterDTO);
    }

    @PostMapping("/update")
    CharacterDTO updateCharacter(@RequestBody CharacterDTO newCharacterDTO) {
        return characterService.saveAndGet(newCharacterDTO);
    }

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
//    todo custom
}
