package by.it.academy.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private long teamId;
    private String teamName;
    @Singular("member")
    private List<User> members = new ArrayList<>();
    @Singular("task")
    private List<Task> tasks = new ArrayList<>();
}
