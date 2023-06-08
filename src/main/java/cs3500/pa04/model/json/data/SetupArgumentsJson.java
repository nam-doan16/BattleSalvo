package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetupArgumentsJson(
    @JsonProperty("width") int width,
    @JsonProperty("height") int height,
    @JsonProperty("fleet-spec") FleetSpecJson fleetSpec
) {
}
