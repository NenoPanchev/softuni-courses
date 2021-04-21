package spring.web.exams.andreys.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class UserServiceModel extends BaseServiceModel{
    private String username;
    private String password;
    private String email;
    private BigDecimal budget;
}
