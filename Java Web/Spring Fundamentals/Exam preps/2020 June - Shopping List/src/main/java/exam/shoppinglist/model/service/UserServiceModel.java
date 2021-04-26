package exam.shoppinglist.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserServiceModel extends BaseServiceModel {
    private String username;
    private String email;
    private String password;
}
