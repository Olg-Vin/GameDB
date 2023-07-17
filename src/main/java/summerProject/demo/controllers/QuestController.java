package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.services.QuestService;

import java.util.List;

@RestController
@RequestMapping("/api/quest")
public class QuestController {
    @Autowired
    private QuestService questService;
    @GetMapping("/")
    List<QuestDTO> all(){
        return questService.getAll();
    }
    @GetMapping("/{id}")
    QuestDTO getOne(@PathVariable String id){
        return questService.get(id);
    }

    @PostMapping("/add.text")
    QuestDTO newQuest(@RequestBody QuestDTO newDTO) {
        return questService.saveAndGet(newDTO);
    }

    @PostMapping("/update")
    QuestDTO updateQuest(@RequestBody QuestDTO newDTO) {
        return questService.saveAndGet(newDTO);
    }
    @DeleteMapping("/delete/{id}")
    void deleteQuest(@PathVariable String id) {
        questService.delete(id);
    }
}
