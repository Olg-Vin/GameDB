package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.models.Quest;
import summerProject.demo.repositories.QuestRepository;
import summerProject.demo.services.QuestService;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService<String > {
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(QuestDTO questDTO) {
        questRepository.save(modelMapper.map(questDTO, Quest.class));
    }

    @Override
    public QuestDTO saveAndGet(QuestDTO questDTO) {
        Quest c = modelMapper.map(questDTO, Quest.class);
        return modelMapper.map(questRepository.save(c), QuestDTO.class);
    }

    @Override
    public QuestDTO get(String s) {
        return modelMapper.map(questRepository.findById(s), QuestDTO.class);
    }

    @Override
    public List<QuestDTO> getAll() {
        return questRepository.findAll().
                stream().map((s)->modelMapper.map(s, QuestDTO.class)).toList();
    }

    @Override
    public void update(QuestDTO questDTO) {
        questRepository.save(modelMapper.map(questDTO, Quest.class));
    }

    @Override
    public void delete(String s) {
        questRepository.deleteById(s);
    }
}
