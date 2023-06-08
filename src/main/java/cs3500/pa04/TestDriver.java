package cs3500.pa04;

import cs3500.pa04.controller.ProxyController;
import cs3500.pa04.controller.input.Reader;
import cs3500.pa04.controller.player.ComputerPlayerController;
import cs3500.pa04.controller.player.ManualPlayerController;
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

    // uncomment line 26 to use RandomPlayerController instead of ManualPlayerController
    // ProxyReferee proxyReferee = new ProxyReferee(server, new RandomPlayerController());
    ProxyController proxyController = new ProxyController(server, new ManualPlayerController(new Reader(new InputStreamReader(System.in)), new View(System.out), 10, 10, new Random()));
    proxyController.run();
  }
}
