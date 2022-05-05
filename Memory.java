import java.io.FileInputStream;
import java.io.FileNotFoundException;

//package Simulator;

public class Memory {
    public static final int MAX_MEMORY = 1024;

    public short [] locations = new short [MAX_MEMORY];

    public void clearMemory() {
        System.out.println("clearMemory");
        for (int i = 0; i <= MAX_MEMORY; i++) {
            locations[i] = 0;
        }
    }

    public short getLocation(short locationNumber) {
        System.out.println("getLocation returns="+locations [locationNumber]+" at location"+locationNumber);
        return locations [locationNumber];
    }

    public void setLocation(short locationNumber, short newValue) {
        System.out.println("setLocation with value="+newValue+" at "+locationNumber);
        locations [locationNumber] = newValue;
    }

    public short loadMemory(String filename) {
        System.out.println("loadMemory");
        short address, dataValue;
        FileInputStream in;
    }
}
