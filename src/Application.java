package src;

import src.components.*;
import src.utils.ClearScreen;
import src.utils.ThreadHandler;

public class Application {
  public static void main(String[] args) {
    ClearScreen.clear();
    Road road = new Road(20, 4);
    Player player = new Player();

    road.build();
    road.setPlayer(player);
    
    ThreadHandler.create(road);
    player.startListener();    
  }
}
