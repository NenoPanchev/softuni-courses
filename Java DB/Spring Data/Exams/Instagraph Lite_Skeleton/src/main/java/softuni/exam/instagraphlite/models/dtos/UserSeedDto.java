package softuni.exam.instagraphlite.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserSeedDto {
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String profilePicture;

    public UserSeedDto() {
    }

    @NotNull
    @Length(min = 2, max = 18)
    public String getUsername() {
        return username;
    }

    public UserSeedDto setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @Length(min = 4)
    public String getPassword() {
        return password;
    }

    public UserSeedDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank
    public String getProfilePicture() {
        return profilePicture;
    }

    public UserSeedDto setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }
}
