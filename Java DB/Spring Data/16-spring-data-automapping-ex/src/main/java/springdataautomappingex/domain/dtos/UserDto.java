package springdataautomappingex.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdataautomappingex.domain.entities.Game;
import springdataautomappingex.domain.entities.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @Column(unique = true)
    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid.")
    private String email;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,}$", message = "Password is not valid.")
    private String password;
    private String fullName;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
