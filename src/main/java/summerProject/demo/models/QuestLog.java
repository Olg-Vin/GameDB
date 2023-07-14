package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "quest_log")
public class QuestLog {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Character character;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Quest quest;
}
