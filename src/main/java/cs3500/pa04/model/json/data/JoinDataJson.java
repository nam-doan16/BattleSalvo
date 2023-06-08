package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.types.GameMode;

public record JoinDataJson(
    @JsonProperty("name") String name,
    @JsonProperty("game-type") GameMode gameType
) {
}
