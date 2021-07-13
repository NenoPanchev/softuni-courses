package springdataautomappingex.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterDto {
    @Email(regexp = "^(.+)@(.+)$", message = "Incorrect email.")
    private String email;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,}$", message = "Password is not valid.")
    private String password;
    @NotNull(message = "Full name must not be null.")
    @NotEmpty(message = "Full name cannot be an empty string.")
    private String fullName;

}
