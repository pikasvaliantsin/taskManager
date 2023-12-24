package by.it.academy.services.users;

import by.it.academy.entities.User;
import by.it.academy.repositories.users.UserRepository;
import by.it.academy.repositories.users.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = UserRepositoryImpl.getInstance();

    private static UserService userService;

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public void getDefaultUsers() {
        userRepository.getDefaultUsers();
    }

    @Override
    public User setUser(long id, User user) {
        return userRepository.setUser(id, user);
    }

    @Override
    public boolean isLoginUnique(String login) {
        return userRepository.isLoginUnique(login);
    }

    @Override
    public boolean isAuthorize(String login, String password) {
        return userRepository.isAuthorize(login, password);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    @Override
    public User getUser(long userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public User getUser(String username) {
        return userRepository.getUser(username);
    }
}
