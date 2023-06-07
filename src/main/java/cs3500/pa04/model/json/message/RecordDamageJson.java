package cs3500.pa04.model.json.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a Json representation of the recordDamage method
 *
 * @param methodName method name
 * @param arguments arguments of the method
 */
public record RecordDamageJson(
    @JsonProperty("method-name") String methodName,
    @JsonProperty("arguments") JsonNode arguments
) implements JsonMessageFormat {
}
