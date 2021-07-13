package springdataautomappingex.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdataautomappingex.domain.entities.enums.OrderStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity{
    @ManyToOne
    private User buyer;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            inverseJoinColumns = @JoinColumn(name = "ordered_game_id", referencedColumnName = "id")
    )
    private Set<Game> orderedGames = new LinkedHashSet<>();
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.IN_PROGRESS;
}
