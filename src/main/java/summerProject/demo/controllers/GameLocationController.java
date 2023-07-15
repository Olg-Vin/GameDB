package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import summerProject.demo.dtos.CharacterDTO;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.services.CharacterService;
import summerProject.demo.services.GameLocationService;

import java.util.List;

@RestController
@RequestMapping("/api/table/location")
public class GameLocationController {
    @Autowired
    private GameLocationService gameLocationService;
    @GetMapping("/")
    List<GameLocationDTO> all(){
        return gameLocationService.getAllGameLocation();
    }
}

