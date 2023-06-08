package cs3500.pa04;

import cs3500.pa04.controller.BattleSalvoController;
import cs3500.pa04.controller.input.Reader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

/**
 * This is the main driver of this project.
 */
public class Driver {

  /**
   * Prevents instances of Driver from being made
   */
  private Driver() {}

  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    Appendable output = new PrintStream(System.out);
    Reader reader = new Reader(new InputStreamReader(System.in));
    BattleSalvoController battleSalvo = new BattleSalvoController(output, reader, new Random());
    battleSalvo.run();
  }
}