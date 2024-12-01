package src.components;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import src.interfaces.Obstacle;
import src.utils.ClearScreen;
import src.utils.Render;

public class Road {
  final private int length;
  private int[][] matrix;
  Player player;

  public Road(int length, int width) {
    this.length = length;
    this.matrix = new int[width + 2][length];
  }

  public void build() {
    int[] base = new int[length];
    int[] end = new int[length];
    for (int i = 0; i <base.length; i++) {
      base[i] = 8;
      end[i] = 9;
    }
    matrix[0] = end;
    matrix[matrix.length -1] = base;
    for (int i = 1; i < matrix.length -1; i++) {
      Obstacle test;
      if (i % 2 == 0) {
        test = new Truck();
      } else {
        test = new Monster();
      }
      Lane lane = new Lane(length, test);
      lane.build();
      ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
      Runnable periodicTask = new Runnable() {
        public void run() {
          lane.running();
        }
      };
      Random rand = new Random();
      int number = rand.nextInt(500) + 500;
      executor.scheduleAtFixedRate(periodicTask, 0, number, TimeUnit.MILLISECONDS);
      matrix[i] = lane.getMap();
    }
  }

  public void setPlayer(Player player) {
    this.player = player;
    this.player.setX(length/2);
    this.player.setY(matrix.length - 1);
    this.player.setMaxX(length - 1);
    this.player.setMaxY(matrix.length - 1);
  }

  public void run() {
    ClearScreen.clear();
    for (int i = 0; i < matrix.length; i++) {
      int[] is = matrix[i];
      if (i == player.getY()) {
        Render.run(is, player.getX());
      } else {
        Render.run(is, null);
      }
    }
  }
}
