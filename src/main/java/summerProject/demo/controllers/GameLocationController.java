package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.services.GameLocationService;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class GameLocationController {
    @Autowired
    private GameLocationService gameLocationService;
    @GetMapping("/")
    List<GameLocationDTO> all(){
        return gameLocationService.getAll();
    }
    @GetMapping("/{id}")
    GameLocationDTO getOne(@PathVariable String id){
        return gameLocationService.get(id);
    }

    @PostMapping("/add.text")
    GameLocationDTO newLocation(@RequestBody GameLocationDTO newDTO) {
        return gameLocationService.saveAndGet(newDTO);
    }

    @PostMapping("/update")
    GameLocationDTO updateLocation(@RequestBody GameLocationDTO newDTO) {
        return gameLocationService.saveAndGet(newDTO);
    }
    @DeleteMapping("/delete/{id}")
    void deleteLocation(@PathVariable String id) {
        gameLocationService.delete(id);
    }
}

