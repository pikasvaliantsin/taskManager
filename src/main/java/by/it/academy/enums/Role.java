package by.it.academy.enums;

public enum Role {
    USER("User"),
    ADMIN("Admin");


    private String roleName;

    Role(String role) {
        this.roleName = role;
    }
}
