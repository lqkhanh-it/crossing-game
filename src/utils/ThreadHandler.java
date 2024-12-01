package src.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import src.components.Road;

public class ThreadHandler {
  static public void create(Road road) {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    Runnable periodicTask = new Runnable() {
      public void run() {
        road.run();
      }
    };
    executor.scheduleAtFixedRate(periodicTask, 0, 200, TimeUnit.MILLISECONDS);
  }
}
