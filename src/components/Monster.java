package src.components;

import src.abstracts.Obstacle;

public class Monster extends Obstacle implements src.interfaces.Obstacle {
  static final private int length = 2;
  static final private String[] list = {"xxx", "ooo"};

  @Override
  public int getLength() {
    return length;
  }
}
