package ex02;

public class Program {
  public static void main(String[] args) {
    UsersArrayList usersArrayList = new UsersArrayList();
    System.out.println(usersArrayList.getUserCount());
    System.out.println(usersArrayList.getUserByIndex(0));
    System.out.println(usersArrayList.getUserByIndex(1));
    try {
      System.out.println(usersArrayList.getUserById(0));
      System.out.println(usersArrayList.getUserById(1));
    } catch (UserNotFoundException e) {
      System.out.println(e.getMessage());
    }
    for (int i = 0; i < 95; i++) {
      User user = new User(Integer.toString(i));
      usersArrayList.addUser(user);
    }
    System.out.println(usersArrayList.getUserByIndex(2));
    System.out.println(usersArrayList.getUserByIndex(95));
    System.out.println(usersArrayList.getUserByIndex(100));
    try {
      System.out.println(usersArrayList.getUserById(2));
      System.out.println(usersArrayList.getUserById(95));
      System.out.println(usersArrayList.getUserById(101));
    } catch (UserNotFoundException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(usersArrayList.getUserCount());
  }
}
