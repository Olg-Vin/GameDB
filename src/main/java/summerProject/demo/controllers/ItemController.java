package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.ItemDTO;
import summerProject.demo.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/table/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    List<ItemDTO> all(){
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    ItemDTO getOne(@PathVariable String id){
        return itemService.get(id);
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
}
