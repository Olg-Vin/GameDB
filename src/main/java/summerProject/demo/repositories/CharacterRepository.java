package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, String> {
}
