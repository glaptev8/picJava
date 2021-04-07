package ex01;

public class UserIdsGenerator {

  private int id = 0;
  private static UserIdsGenerator userIdsGenerator;

  private UserIdsGenerator() {};

  public static UserIdsGenerator getInstance() {
    if (userIdsGenerator == null) {
      userIdsGenerator = new UserIdsGenerator();
    }
    return userIdsGenerator;
  }

  public int generateId() {
    return this.id++;
  }
}
