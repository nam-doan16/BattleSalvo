package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON format of this record:
 *
 * <p>
 *   <code>
 *     {
 *       "fleet": ShipJson[]
 *     }
 *   </code>
 * </p>
 *
 * @param fleet of ships of the player represented by an array of ships
 */
public record FleetJson(
    @JsonProperty("fleet") ShipJson[] fleet) {
}
