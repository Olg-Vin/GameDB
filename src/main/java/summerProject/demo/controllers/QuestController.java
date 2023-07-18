package summerProject.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import summerProject.demo.dtos.GameLocationDTO;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.exceptions.ResourceNotFoundException;
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
    QuestDTO getOne(@PathVariable String id) throws Throwable{
        return (QuestDTO) questService.get(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping("/add")
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

    @PostMapping("/custom6/{locationName}")
    List<QuestDTO> locationWhere(@PathVariable String locationName) {
        return questService.findAllQuestsByLocation(locationName);
    }
}
