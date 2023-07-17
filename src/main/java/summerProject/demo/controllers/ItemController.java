package summerProject.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.exceptions.ResourceNotFoundException;
import summerProject.demo.models.Characteristic;
import summerProject.demo.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    List<ItemDTO> all(){
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    ItemDTO getOne(@PathVariable String id) throws Throwable{
        return (ItemDTO) itemService.get(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping("/add")
    ItemDTO newItem(@RequestBody ItemDTO newDTO) {
        return itemService.saveAndGet(newDTO);
    }

    @PostMapping("/update")
    ItemDTO updateItem(@RequestBody ItemDTO newDTO) {
        return itemService.saveAndGet(newDTO);
    }
    @DeleteMapping("/delete/{id}")
    void deleteItem(@PathVariable String id) {
        itemService.delete(id);
    }

    @PostMapping("/custom2/{name}")
    List<QuestDTO> questContent(@PathVariable String name) {
        return itemService.findAllItems(name);
    }

    @PostMapping("/custom3/{name}")
    List<CharacteristicDTO> itemCharacteristic(@PathVariable String name) {
        return itemService.findAllCharacteristics(name);
    }
}
