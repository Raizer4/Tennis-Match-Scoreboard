package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "matches")
@Entity()
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "player_1", referencedColumnName = "id", nullable = false)
    private Player firstPlayer;


    @ManyToOne
    @JoinColumn(name = "player_2", referencedColumnName = "id", nullable = false)
    private Player secondPlayer;


    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id", nullable = false)
    private Player winner;





}
