package by.it.academy.enums;

public enum Priority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String priorityName;
    Priority(String priorityName) {
        this.priorityName = priorityName;
    }
}
