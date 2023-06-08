package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.types.GameMode;

/**
 * Represents the data sent through the join method as a JSON
 *
 * @param name Github name
 * @param gameType either "SINGLE" or "MULTI"
 */
public record JoinDataJson(
    @JsonProperty("name") String name,
    @JsonProperty("game-type") GameMode gameType
) {
}
