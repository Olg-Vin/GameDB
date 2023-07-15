package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.QuestLog;

@Repository
public interface QuestLogRepository extends JpaRepository<QuestLog, String> {
}
