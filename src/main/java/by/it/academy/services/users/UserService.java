package by.it.academy.services.users;

import by.it.academy.entities.User;

import java.util.List;

public interface UserService {
    List<User> readUsers();

    User createUser(User user);

    void getDefaultUsers();

    User setUser(long id, User user);

    boolean isLoginUnique(String login);

    boolean isAuthorize(String login, String password);

    void deleteUser(User user);

    User getUser(long userId);

    User getUser(String username);


}
