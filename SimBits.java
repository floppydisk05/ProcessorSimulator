/**
Support class for the Java simulator project.
This class contains a number of methods which perform some of the
tricky bit manipulation required by the project.
Version dated 4-Feb-98
*/
//package Simulator;

import java.io.PrintWriter;

public class SimBits {
  // Used by writeHex () method
  private static char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

  /**
      Method to convert an int into a short by taking the last 16 bits
      of the integer value. This method is required after adding or
      subtracting two short values together.
     */
  public static short last16bits(int i) {
    // Create local copy of value
    int val = i;
    //Take modulus of highest 16 bit number
    val = val % 65536;
    // Cast and return the value
    return (short) val;
  } // last16bits ()

  /**
      Method to extract and return the last 10 bits of a value
     */
  public static short last10bits(short value) {
    // Perform bit by bit AND operation to zero all but last 10 bits
    int temp = value & 1023;
    return (short) temp;
  } // last10bits ()

  /**
      Method to extract field A (i.e. the top four bits) from an instruction.
      The result is a short integer in the range 0..15
     */
  public static short getFieldA(short instr) {
    int temp = instr >> 12;
    temp = temp & 15;
    System.out.println("In getFieldA returned A=" + temp + " at " + instr);
    return (short) temp;
  } // getFieldA ()

  /**
      Method to extract field B from an instruction
      The result is a short integer in the range 0..3
     */
  public static short getFieldB(short instr) {
    int temp = instr >> 10;
    temp = temp & 3;
    return (short) temp;
  } // getFieldB ()

  /**
      Method to extract field C from an instruction
      The result is a short integer in the range 0..1023
     */
  public static short getFieldC(short instr) {
    return last10bits(instr);
  } // getFieldC ()

  /**
      Method to write a value in hexadecimal to a TextOutput channel.
      The method always outputs 4 hex digits, limiting its useful range
      to that of a short integer.
     */
  public static void writeHex(PrintWriter out, int hex) {
    // Create local copy of value and an array to store digits
    int val = hex;
    int[] digit = new int[4];
    // Loop to extract digit values (least significant first)
    for (int i = 0; i <= 3; i++) {
      digit[i] = val & 15;
      val = val >> 4;
    } // for i++

    // Loop to convert digit values to printable characters
    for (int i = 3; i >= 0; i--) {
      out.print(hexDigit[digit[i]]);
    } // for i--
  } //writeHex()
} //SimBits
