package cs3500.pa04.model.json.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON format of this record:
 *
 * <p>
 *   <code>
 *     {
 *       "volley": CoordJson[]
 *     }
 *   </code>
 * </p>
 *
 * @param volley the volley of shots represented by an array of coords
 */
public record VolleyJson(
    @JsonProperty("volley") CoordJson[] volley) {
}
