package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.Quest;

@Repository
public interface QuestRepository extends JpaRepository<Quest, String > {
}
