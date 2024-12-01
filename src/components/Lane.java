package src.components;

import src.interfaces.Obstacle;

public class Lane {
  private int length;
  private Obstacle ob;
  static private int space = 2;
  private int[] map;

  public Lane(int length, Obstacle ob) {
    this.length = length;
    this.ob = ob;
  }

  public void running() {
    int first = map[0];
    for (int i = 1; i < map.length;i++ ) {
      map[i-1] = map[i];
    }
    map[map.length - 1] = first;
  }

  public void build() {
    int obLen = ob.getLength();
    int[] arr = new int[length];
    int temp = obLen;
    for (int i = 0; i< length; i++) {
      if (temp > 0) {
        arr[i] = 1;
        temp--;
      } else {
        temp = obLen;
        i+= (space-1);
      }
    }
    this.map = arr;
  }

  public int[] getMap() {
    return map;
  }
}
