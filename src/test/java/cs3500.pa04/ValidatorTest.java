package cs3500.pa04;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for Validator
 */
class ValidatorTest {
  private String[] validNumStrArr;
  private String[] badStrArr;
  private String[] negativeNumArr;
  private int[] exampleCoord;

  /**
   * Initialization before each test method
   */
  @BeforeEach
  void setUp() {
    validNumStrArr = new String[] {"4", "5"};
    badStrArr = new String[] {"4", "4lol"};
    negativeNumArr = new String[] {"-1", "5"};
    exampleCoord = new int[] {6, 10};

  }

  /**
   * Testing successful usages of Validator.allNumArray
   */
  @Test
  void testAllNumArray() {
    int[] validNumArr = Validator.allNumArray(validNumStrArr, 2);
    assertEquals(validNumArr[0], 4);
    assertEquals(validNumArr[1], 5);
  }

  /**
   * Testing unsuccessful usages of Validator.allNumArray
   */
  @Test
  void testAllNumArrayFail() {
    Exception e = assertThrows(IllegalArgumentException.class,
        () -> Validator.allNumArray(null, 2), "Invalid Arguments!");
    assertEquals(e.getMessage(), "Invalid Arguments!");

    e = assertThrows(IllegalArgumentException.class,
        () -> Validator.allNumArray(validNumStrArr, 1), "Invalid Arguments!");
    assertEquals(e.getMessage(), "Invalid Arguments!");

    e = assertThrows(IllegalArgumentException.class,
        () -> Validator.allNumArray(badStrArr, 2),
        "Non-numerical number input!");
    assertEquals(e.getMessage(), "Non-numerical number input!");

    e = assertThrows(IllegalArgumentException.class,
        () -> Validator.allNumArray(negativeNumArr, 2),
        "No negative numbers");
    assertEquals(e.getMessage(), "No negative numbers");
  }

  /**
   * Testing Validator.isInBound
   */
  @Test
  void testIsInBound() {
    assertTrue(Validator.isInBound(exampleCoord, 15, 15, 0));

    // 1st element of exampleCoord does not fit between the height and lowerbound
    assertFalse(Validator.isInBound(exampleCoord, 15, 15, 7));

    assertFalse(Validator.isInBound(exampleCoord, 15, 15, 11));

    // 2nd element of exampleCoord does not fit between the width and lowerbound
    assertFalse(Validator.isInBound(exampleCoord, 9, 15, 5));
    assertFalse(Validator.isInBound(exampleCoord, 15, 15, 11));

    // 1st and 2nd is out of reach of height, width, and lowerbound
    assertFalse(Validator.isInBound(exampleCoord, 0, 0, 0));

    // though not used, testing when list isn't the right size
    assertTrue(Validator.isInBound(new int[3], 0, 0, 0));

    // testing null
    assertFalse(Validator.isInBound(null, 0, 0, 0));

  }
}