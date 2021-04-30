package exams.heroes.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserServiceModel extends BaseServiceModel {
    private String username;
    private String password;
    private String email;
    private String country;
}
