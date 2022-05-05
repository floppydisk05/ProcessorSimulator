/**
This class defines and object which holds the various registers of the
simulated computer. It needs to be studied in conjunction with the simulator
description document and the hand-out
*/
//package Simulator;

public class Registers {
// short is used for registers as none of them require more than 16 bits.
    short accumulator = 0;      // simulated A register (16 bits)
    short indexRegister = 0;    // simulated X register (10 bits)
    short programCounter = 0;   // simulated PC register (10 bits)
    boolean runBit = false;     // True when program is running (1 bit)

// Getter and setter for accumulator
    public short getA() {
        // returns the current value of the accumulator
        return accumulator;
    }//getA

    public void setA(short newValue) {
        // sets value of accumulator
        accumulator = newValue;
    }//setA

// Getter and setter for indexRegister
    public short getX() {
        // returns current value of indexRegister
        return indexRegister;
    }//getX

    public void setX(short newValue) {
        // sets value of indexRegister
        System.out.println("setX with "+newValue);
        indexRegister = SimBits.last10bits(accumulator);
    } //setX

    // Getter and setter methods for programCounter
    public short getPC () {
        //returns current value of programCounter
        return programCounter;
    } //getPC

    public void setPC (short dataValue) {
        // sets value of programCounter
        programCounter = dataValue;
    }//setPC

    public void incPC () {
        // Increments the PC by one each time an instructionis fetched
        programCounter ++;
        programCounter = SimBits.last10bits(programCounter);
    }//incPC

    //Initialises runBit to true when program is running
    public void runBit () {
        while (getA() != 0000) {
            runBit = true;
        }//end while
    }//runBit
}//Registers
