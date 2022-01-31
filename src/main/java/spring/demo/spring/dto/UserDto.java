package spring.demo.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.demo.spring.entities.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    public UserDto(User user) {
        id = user.getId();
        username = getUsername();
        password = user.getPassword();
        email = user.getEmail();
    }
}
