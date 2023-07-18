package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.Quest;
import summerProject.demo.models.RewardLog;

import java.util.List;

@Repository
public interface QuestRepository extends JpaRepository<Quest, String > {
    @Query(value = "SELECT q FROM Quest q WHERE q.questPlace.name = :locationName")
    List<Quest> findAllQuestsByLocation(@Param("locationName") String locationName);
}
