package springdataautomappingex.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Set<Game> orderedGames = new LinkedHashSet<>();
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.IN_PROGRESS;
}
