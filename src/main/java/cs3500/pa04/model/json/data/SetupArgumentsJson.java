package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a setup argument that was sent by the server
 *
 * @param width width of board
 * @param height height of board
 * @param fleetSpec specifications for the fleet on the board
 */
public record SetupArgumentsJson(
    @JsonProperty("width") int width,
    @JsonProperty("height") int height,
    @JsonProperty("fleet-spec") FleetSpecJson fleetSpec
) {
}
