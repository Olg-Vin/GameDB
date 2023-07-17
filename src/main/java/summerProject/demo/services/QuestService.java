package summerProject.demo.services;

import summerProject.demo.dtos.QuestDTO;

import java.util.List;

public interface QuestService<ID> {
    void save(QuestDTO questDTO);
    QuestDTO saveAndGet(QuestDTO questDTO);//    for foreign key

    QuestDTO get(ID id);
    List<QuestDTO> getAll();

    void update(QuestDTO questDTO);
    void delete(ID id);

    void addItem(String questName, String itemName, int count);
}
