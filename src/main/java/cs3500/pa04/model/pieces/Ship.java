package cs3500.pa04.model.pieces;

import cs3500.pa04.model.types.Coord;
import cs3500.pa04.model.types.ShipType;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Ship on a board
 */
public class Ship {
  private final ShipType shipType;
  private final ArrayList<Coord> shipLocation;
  private final ArrayList<Coord> hitShips;
  private int floatStatus;

  /**
   * Constructor for Ship
   *
   * @param shipType this ship's type
   * @param shipLocation list of coordinates representing where each piece of this ship lives
   */
  public Ship(ShipType shipType, ArrayList<Coord> shipLocation) {
    this.hitShips = new ArrayList<>();
    this.shipType = shipType;
    this.shipLocation = shipLocation;
    this.floatStatus = 0;
  }

  /**
   * Fills the given board with a symbol representing this ship's type at the ship's coordinates
   *
   * @param board battlesalvo board
   */
  public void fillBoard(char[][] board) {
    for (Coord coordinate : shipLocation) {
      board[coordinate.getY()][coordinate.getX()] = shipType.toString().charAt(0);
    }
  }

  /**
   * true - afloat piece
   * false - sunken piece
   *
   * @return whether this ship is sunk or not
   */
  public boolean isSunk() {
    // there are no floating pieces, so the entire boat is sunk
    return this.floatStatus >= shipType.size;
  }

  /**
   * determines if the given list of coordinates hit any of this ship's coordinates
   * if so, update the state of this ship.
   *
   * @param opponentHits - list of opponent's targetted coordinates
   * @return successfully hit coordinates
   */
  public ArrayList<Coord> reportShipDamage(List<Coord> opponentHits) {
    for (Coord coord : this.shipLocation) {
      for (Coord opponentCoord : opponentHits) {
        if (opponentCoord.equals(coord)) {
          this.hitShips.add(coord);
          this.floatStatus++;
        }
      }
    }
    return this.hitShips;
  }
}
