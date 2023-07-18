package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.GameLocation;

import java.util.List;

@Repository
public interface GameLocationRepository extends JpaRepository<GameLocation, String> {
    @Query(value = "SELECT gl FROM GameLocation gl WHERE gl.maxNPC < :count")
    List<GameLocation> findAllLocationWhereMaxNPCLessBy(@Param("count") int count);
}
