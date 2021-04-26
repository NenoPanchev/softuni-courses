package exams.gira.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    @NotNull(message = "Username required")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Email(message = "Email cannot be empty!")
    @NotNull(message = "Email cannot be empty!")
    @NotBlank(message = "Email cannot be empty!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    @NotNull(message = "Password required")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
