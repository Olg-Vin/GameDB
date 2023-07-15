package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.RewardLog;

@Repository
public interface RewardLogRepository extends JpaRepository<RewardLog, String> {
}
