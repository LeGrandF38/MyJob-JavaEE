package model;

public interface IUser {
    int createUser(User user);
    void updateUser(User newUser);
    void deleteUser(int userId);
}
