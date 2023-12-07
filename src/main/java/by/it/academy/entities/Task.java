package by.it.academy.entities;

import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private long taskId;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private User assignee;
    private Team team;
}
