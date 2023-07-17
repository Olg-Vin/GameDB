package summerProject.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerProject.demo.dtos.QuestDTO;
import summerProject.demo.models.Item;
import summerProject.demo.models.Quest;
import summerProject.demo.models.RewardLog;
import summerProject.demo.models.compositeKeys.RewardLogKeys;
import summerProject.demo.repositories.ItemRepository;
import summerProject.demo.repositories.QuestRepository;
import summerProject.demo.repositories.RewardLogRepository;
import summerProject.demo.services.QuestService;

import java.util.List;
import java.util.Optional;

@Service
public class QuestServiceImpl implements QuestService<String > {
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RewardLogRepository rewardLogRepository;
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
    public Optional<QuestDTO> get(String s) {
        return Optional.ofNullable(modelMapper.map(questRepository.findById(s), QuestDTO.class));
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

    @Override
    public void addItem(String questName, String itemName, int count) {
        Quest quest = questRepository.findById(questName).orElseThrow();
        Item item = itemRepository.findById(itemName).orElseThrow();
//        create composite key
        RewardLogKeys key = new RewardLogKeys();
        key.setQuestName(questName);
        key.setItemName(itemName);
        RewardLog rewardLog = new RewardLog(key, count);
        rewardLog.setQuest(quest);
        rewardLog.setItem(item);
        rewardLogRepository.save(rewardLog);
    }
}
