package by.it.academy.entities;

import by.it.academy.enums.Role;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long userId;
    private String username;
    private String email;
    private String password;
    private Role role;

    @Singular("team")
    private List<Team> teams;

    @Singular("task")
    private List<Task> tasks;
}
