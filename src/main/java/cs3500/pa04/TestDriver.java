package cs3500.pa04;

import cs3500.pa04.controller.ProxyController;
import cs3500.pa04.controller.input.Reader;
import cs3500.pa04.controller.player.AbstPlayerController;
import cs3500.pa04.controller.player.ComputerPlayerController;
import cs3500.pa04.view.View;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class TestDriver {
  public static void main(String[] args) throws IOException {
    runClient("0.0.0.0", 35001);
  }

  private static void runClient(String host, int port)
      throws IOException, IllegalStateException {
    Socket server = new Socket(host, port);


    AbstPlayerController player
        = new ComputerPlayerController(new Reader(new InputStreamReader(System.in)),
        6, 6, new View(System.out), new Random());
    ProxyController proxyController = new ProxyController(server, player);
    proxyController.run();
  }
}
