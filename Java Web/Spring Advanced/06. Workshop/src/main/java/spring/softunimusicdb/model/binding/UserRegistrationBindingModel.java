package spring.softunimusicdb.model.binding;

import org.hibernate.validator.constraints.Length;
import spring.softunimusicdb.model.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch(
        first = "password",
        second = "confirmPassword"
)
public class UserRegistrationBindingModel {
    private String username;
    private String email;
    private String fullName;
    private String password;
    private String confirmPassword;

    public UserRegistrationBindingModel() {
    }

    @Length(min = 3, message = "Username length must be more than 3 characters")
    public String getUsername() {
        return username;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotEmpty
    @Email(message = "Must be a valid email!")
    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Length(min = 3, message = "Full name length must be more than 3 characters")
    public String getFullName() {
        return fullName;
    }

    public UserRegistrationBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Length(min = 5, max = 20, message = "Password length must be between 5 and 20 characters and passwords should match.")
    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Length(min = 5, max = 20)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
