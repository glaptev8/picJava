package ex02;

public interface UsersList {
  boolean addUser(User user);

  User getUserByIndex(int index);

  int getUserCount();

  User getUserById(int id);
}
