package cs3500.pa04.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa04.controller.player.AbstPlayerController;
import cs3500.pa04.model.JsonUtils;
import cs3500.pa04.model.json.message.JoinJson;
import cs3500.pa04.model.json.message.MessageJson;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ProxyController {
  private final Socket server;
  private final InputStream in;
  private final PrintStream out;
  private final AbstPlayerController player;
  private final ObjectMapper mapper = new ObjectMapper();

  /**
   * Constructor for ProxyController
   * Constructs an instance of a ProxyPlayer
   *
   * @param server
   * @param player
   * @throws IOException
   */
  public ProxyController(Socket server, AbstPlayerController player) throws IOException {
    this.server = server;
    this.player = player;
    this.in = server.getInputStream();
    this.out = new PrintStream(server.getOutputStream());
  }

  public void run() {
    try {
      JsonParser parser = this.mapper.getFactory().createParser(this.in);

      while (!this.server.isClosed()) {
        MessageJson message = parser.readValueAs(MessageJson.class);
        delegateMessage(message);
      }
    } catch (IOException e) {

    }
  }

  private void delegateMessage(MessageJson message) {
    this.handleJoin();
  }

  private void handleJoin() {
    String[] input = new String[] {"nam-doan16", "SINGLE"};
    JoinJson join = new JoinJson("join", mapper.valueToTree(input));

    this.out.println(JsonUtils.serializeRecord(join));
  }

}
