package cs3500.pa04.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa04.controller.input.Reader;
import cs3500.pa04.controller.mock.Mocket;
import cs3500.pa04.controller.player.AbstPlayerController;
import cs3500.pa04.controller.player.ComputerPlayerController;
import cs3500.pa04.model.JsonUtils;
import cs3500.pa04.model.json.data.CoordJson;
import cs3500.pa04.model.json.data.FleetSpecJson;
import cs3500.pa04.model.json.data.SetupArgumentsJson;
import cs3500.pa04.model.json.data.VolleyJson;
import cs3500.pa04.model.json.message.SetupJson;
import cs3500.pa04.model.json.message.TakeShotsJson;
import cs3500.pa04.view.View;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test correct responses for different requests from the socket using a Mock Socket (mocket)
 */
public class ProxyControllerTest {
  private ByteArrayOutputStream testLog;
  private ProxyController controller;


  /**
   * Reset the test log before each test is run.
   */
  @BeforeEach
  public void setup() {
    this.testLog = new ByteArrayOutputStream(2048);
    assertEquals("", logToString());
  }

  /**
   * Check that the server returns a guess when given a hint.
   */
  @Test
  public void testSetupMethod() {
    // for setup
    FleetSpecJson fleetSpecs = new FleetSpecJson(2, 1, 3, 1);
    SetupArgumentsJson setupArgs = new SetupArgumentsJson(8, 10, fleetSpecs);
    JsonNode sample = createSetupArgs(setupArgs);

    // for takeShots
    CoordJson[] listCoords = new CoordJson[3];
    listCoords[0] = new CoordJson(0, 0);
    listCoords[1] = new CoordJson(1, 0);
    listCoords[2] = new CoordJson(2, 2);

    VolleyJson volley = new VolleyJson(listCoords);
    JsonNode sample2 = createTakeShots(volley);

    // for endGame


    Mocket socket = new Mocket(this.testLog, List.of(sample.toString(), sample2.toString()));
    Appendable output = new PrintStream(System.out);
    Reader reader = new Reader(new InputStreamReader(System.in));
    View view = new View(output);
    AbstPlayerController testPlayer =
        new ComputerPlayerController(reader, 10, 8, view, new Random(15));

    try {
      this.controller = new ProxyController(socket, testPlayer);
    } catch (IOException e) {
      fail();
    }

    this.controller.run();

    //String expected = "{\"method-name\":\"setup\",\"arguments\":{\"fleet\":[{\"coord\":{\"x\":0,\"y\":2},\"length\":6,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":7,\"y\":2},\"length\":6,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":6,\"y\":1},\"length\":5,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":2,\"y\":0},\"length\":4,\"direction\":\"HORIZONTAL\"},{\"coord\":{\"x\":1,\"y\":6},\"length\":4,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":6,\"y\":6},\"length\":4,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":5,\"y\":5},\"length\":3,\"direction\":\"VERTICAL\"}]}}\n";
    assertEquals("{\"method-name\":\"setup\"", logToString().substring(0, 22));

    /*
    socket = new Mocket(this.testLog, List.of(sample2.toString()));
    try {
      this.controller = new ProxyController(socket, testPlayer);
    } catch (IOException e) {
      fail();
    }

    this.controller.run();

    // currentShips of the proxy controller is null for the takeShots test
    expected = "";
    assertEquals(expected, logToString());*/
  }

  /**
   * Converts the ByteArrayOutputStream log to a string in UTF_8 format
   * @return String representing the current log buffer
   */
  private String logToString() {
    return testLog.toString(StandardCharsets.UTF_8);
  }

  private JsonNode createSetupArgs(Record setupArgs) {
    SetupJson setup = new SetupJson("setup", JsonUtils.serializeRecord(setupArgs));
    return JsonUtils.serializeRecord(setup);
  }

  private JsonNode createTakeShots(Record takeShotsArg) {
    TakeShotsJson takeShots = new TakeShotsJson("take-shots", JsonUtils.serializeRecord(takeShotsArg));
    return JsonUtils.serializeRecord(takeShots);
  }
}
