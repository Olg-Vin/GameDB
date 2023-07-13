package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.GameLocation;

@Repository
public interface GameLocationRepository extends JpaRepository<GameLocation, String> {
}
