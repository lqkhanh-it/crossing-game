package src.utils;

public class ClearScreen {
  // This will work on terminals that support ANSI escape codes
  // It will not work on Windows' CMD
  // It will not work in the IDE's terminal
  public static void clear() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  }  
}