package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.Characteristic;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
//    todo create custom methods more then two!!
}
