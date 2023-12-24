package by.it.academy.enums;

public enum Status {
    NEW("NEW"),
    IN_PROGRESS("IN PROGRESS"),
    COMPLETED("COMPLETED");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }
}
