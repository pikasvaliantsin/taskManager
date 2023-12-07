package by.it.academy.repositories.users;

import by.it.academy.entities.User;
import by.it.academy.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository userRepository;

    private final List<User> users = new ArrayList<>();


    private UserRepositoryImpl() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    @Override
    public User getUser(long userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getUser(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getUserIndex(long userId) {
        return IntStream.range(0, users.size())
                .filter(i -> users.get(i).getUserId() == userId)
                .findFirst()
                .orElse(-1);
    }


    @Override
    public List<User> readUsers() {
        return users;
    }

    @Override
    public User createUser(User user) {
        user.setUserId(users.size() + 1);
        users.add(user);
        return user;
    }

    @Override
    public User setUser(long id, User user) {
        int index = userRepository.getUserIndex(id);
        user.setUserId(id);
        users.set(index, user);
        return user;
    }


    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public void getDefaultUsers() {
        users.add(new User(0L, "admin", "example@gmail.com", "admin", Role.ADMIN, null, null));
        users.add(new User(2L, "user", "valiantsin@gmail.com", "user", Role.USER, null, null));
    }

    @Override
    public boolean isLoginUnique(String login) {
        return users.stream()
                .noneMatch(user -> user.getUsername().equals(login));
    }

    @Override
    public boolean isAuthorize(String login, String password) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(login) && user.getPassword().equals(password));
    }
}
