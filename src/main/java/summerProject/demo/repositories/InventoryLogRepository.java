package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.InventoryLog;

@Repository
public interface InventoryLogRepository extends JpaRepository<InventoryLog, String> {
}
