package ex02;

public class UsersArrayList implements UsersList {

  private User[] userList = new User[10];
  private int length = 0;

  @Override
  public boolean addUser(User user) {
    if (this.length == this.userList.length) {
      User[] userListCope = new User[this.userList.length + 10];
      for (int i = 0; i < this.length; i++) {
        userListCope[i] = this.userList[i];
      }
      userListCope[this.length] = user;
      userList = userListCope;
    }
    else {
      this.userList[this.length] = user;
    }
    length++;
    return true;
  }

  @Override
  public User getUserByIndex(int index) {
    if (index < this.length) {
      return userList[index];
    }
    return null;
  }

  @Override
  public int getUserCount() {
    return this.length;
  }

  @Override
  public User getUserById(int id) {
    for (int i = 0; i < length; i++) {
      User user = this.userList[i];
      if (user.getIdentifier() == id) {
        return user;
      }
    }
    throw new UserNotFoundException("User not found by id = " + id);
  }
}
