package cs3500.pa04.model.json;


import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a Json Message Format for the six methods for BattleSalvo
 */
public interface JsonMessageFormat {
  /**
   * Returns the string representation of one of the method names
   *
   * @return string representation of a method name
   */
  String methodName();

  /**
   * Returns a JsonNode of arguments of this method
   *
   * @return JsonNode of arguments
   */
  JsonNode arguments();
}
