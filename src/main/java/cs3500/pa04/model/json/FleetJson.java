package cs3500.pa04.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.json.ShipJson;

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
