package springdataautomappingex.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdataautomappingex.domain.entities.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid.")
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,}$", message = "Password is not valid.")
    private String password;
    private String fullName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    private Set<Game> games = new LinkedHashSet<>();
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "buyer", targetEntity = Order.class, fetch = FetchType.EAGER)
    private Set<Order> orders = new LinkedHashSet<>();
    @OneToOne
    private Order currentOrder;
}
