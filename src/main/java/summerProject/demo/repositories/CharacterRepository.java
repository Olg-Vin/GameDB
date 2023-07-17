package summerProject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import summerProject.demo.models.Character;
import summerProject.demo.models.Quest;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, String> {
    @Query(value = "SELECT ql.quest FROM QuestLog ql JOIN ql.character q WHERE ql.character.name = :playerName")
    List<Quest> findQuestContentByPlayerName(@Param("playerName") String playerName);
}
