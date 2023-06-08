package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.types.GameResult;

public record EndGameArgsJson(
    @JsonProperty("result") GameResult result,
    @JsonProperty("reason") String reason
) {
}
