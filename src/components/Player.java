package src.components;

import java.io.IOException;

public class Player {
  private int x;
  private int y;

  private int maxX;
  private int maxY;

  private volatile boolean running = true;

  public void setMaxX(int maxX) {
    this.maxX = maxX;
  }

  public void setMaxY(int maxY) {
    this.maxY = maxY;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  void up() {
    if (y > 0) {
      y--;
    }
  }

  void down() {
    if (y < maxY) {
      y++;
    }
  }

  void left() {
    if (x > 0) {
      x--;
    }
  }

  void right() {
    if (x < maxX) {
      x++;
    }
  }

  public void move(char action) {
    switch (action) {
      case 'w':
        up();
        break;
      case 'd':
        right();
        break;
      case 'a':
        left();
        break;
      case 's':
        down();
      case 'x':
        stopListener();
        break;
      default:
        break;
    }
  }

  private void stopListener() {
    running = false;
    Thread.currentThread().interrupt();
    System.out.println("Listener stopped.");
  }

  public void startListener() {
    Thread inputThread = new Thread(() -> {
      try {
        // Enable terminal raw mode (requires platform-specific tools)
        enableRawMode();

        while (running) {
          if (System.in.available() > 0) { // Check if input is available
            char input = (char) System.in.read(); 
            move(input);
          }
        }
      } catch (IOException e) {
        System.err.println("Error reading input: " + e.getMessage());
      } finally {
        disableRawMode();
      }
    });
    inputThread.setDaemon(true);
    inputThread.start();
  }

  private void enableRawMode() throws IOException {
    String[] command = { "/bin/sh", "-c", "stty raw -echo < /dev/tty" };
    Runtime.getRuntime().exec(command);
  }

  private void disableRawMode() {
    try {
      String[] command = { "/bin/sh", "-c", "stty cooked echo < /dev/tty" };
      Runtime.getRuntime().exec(command);
    } catch (IOException e) {
      System.err.println("Failed to restore terminal mode.");
    }
  }
}
