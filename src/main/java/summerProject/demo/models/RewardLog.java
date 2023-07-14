package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reward_log")
public class RewardLog {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Quest quest;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;
}
