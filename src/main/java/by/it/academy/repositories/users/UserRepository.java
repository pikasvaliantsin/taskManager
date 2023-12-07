package by.it.academy.repositories.users;

import by.it.academy.entities.User;

import java.util.List;

public interface UserRepository {
    List<User> readUsers();

    User createUser(User user);

    User setUser(long id, User user);

    void deleteUser(User user);

    void getDefaultUsers();

    boolean isLoginUnique(String login);

    boolean isAuthorize(String login, String password);

    User getUser(long userId);

    User getUser(String username);

    int getUserIndex(long userId);
}
