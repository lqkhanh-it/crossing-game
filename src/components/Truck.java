package src.components;

import src.abstracts.Obstacle;

public class Truck extends Obstacle implements src.interfaces.Obstacle {
  static final private int length = 3;
  static final private String[] list = {"xxx", "ooo"};

  static public String[] getEffect() {
    return list;
  }

  public int getLength() {
    return length;
  }
}
