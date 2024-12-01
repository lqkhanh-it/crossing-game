package src.abstracts;

public abstract class Obstacle {
  public void effect(String[] list) {
      boolean flag = true;
      int index = 0;
      while (flag) {
        System.out.print(list[index]);
        index++;
        if (index >= list.length) {
          index = 0;
        }
      }
  }
}