package springdataautomappingex.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdataautomappingex.domain.entities.enums.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

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
