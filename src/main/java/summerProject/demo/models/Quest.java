package summerProject.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quest")
public class Quest {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "content", length = 512, nullable = false)
    private String content;
    @OneToOne
    @JoinColumn
    private GameLocation questPlace;
    @OneToOne
    @JoinColumn
    private GameLocation returnPlace;
    @Column(name = "reward", length = 255, nullable = false)
    private String reward;

    @OneToMany(mappedBy = "quest")
    private List<RewardLog> rewardLogs = new ArrayList<>();

    @OneToMany(mappedBy = "quest")
    private List<QuestLog> questLogs = new ArrayList<>();
}
