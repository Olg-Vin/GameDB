package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import summerProject.demo.dtos.CharacteristicDTO;
import summerProject.demo.models.Characteristic;
import summerProject.demo.models.Item;
import summerProject.demo.models.Quest;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    @Query(value = "SELECT rl.quest FROM RewardLog rl JOIN rl.item i WHERE i.name = :itemName")
    List<Quest> findAllItemsByQuestName(@Param("itemName") String itemName);
    @Query(value = "SELECT i.properties FROM RewardLog rl JOIN rl.item i JOIN rl.quest q WHERE q.name = :questName")
    List<Characteristic> findAllCharacteristicsForItemByQuestName(@Param("questName") String questName);
}
