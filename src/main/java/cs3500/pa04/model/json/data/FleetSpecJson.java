package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FleetSpecJson(
    @JsonProperty("CARRIER") int carrier,
    @JsonProperty("BATTLESHIP") int battleship,
    @JsonProperty("DESTROYER") int destroyer,
    @JsonProperty("SUBMARINE") int submarine
) {
}
