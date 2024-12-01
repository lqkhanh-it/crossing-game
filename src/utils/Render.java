package src.utils;

public class Render {
  static public void run(int[] list, Integer x) {
    String[] newarr = new String[list.length];
    for (int i=0;i< list.length;i++) {
      if (x != null) {
        if (i == x) {
          newarr[i] = "^";
          continue;
        }
      }
      int key = list[i];
      switch (key) {
        case 9:
          newarr[i] = "=";
          break;
        case 8:
          newarr[i] = ".";
          break;
        case 1:
          newarr[i] = "x";
          break;
        case 0:
          newarr[i] = " ";
          break;
        default:
          break;
      }
    }

    StringBuilder builder = new StringBuilder();
    for (String value : newarr) {
        builder.append(value);
    }
    String text = builder.toString();
    System.out.print("\r\033[K");
    System.out.println(text);
  }
}
