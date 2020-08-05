
public class Bit {

    private boolean value;

    // Constructor:
    public Bit(boolean value) {
        this.value = value;
    }

    public String toString() {
        if (this.value)
            return "1";
        else
            return "0";
    }

    public boolean isOne() {
        if (this.value)
            return true;

        return false;
    }

    public boolean lessThan(Bit digit) {
        if (!this.value & digit.value)
            return true;

        return false;
    }

    public boolean lessEq(Bit digit) {
        if (!this.value)
            return true;
        return false;
    }

    public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) {

        // The following code assures output of True Bit in 2 cases:
        // 1. All of the input Bits are True
        // 2. Exactly one of the input Bits is True
        Bit output = new Bit(false);
        if (A.value)
            output.value = !output.value;
        if (B.value)
            output.value = !output.value;
        if (Cin.value)
            output.value = !output.value;

        return output;
    }

    public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) {

        // The following code assures output of True Bit only if at least 2 of the input Bits are true
        Bit output = new Bit(true);
        int counter = 0;
        if (A.value)
            counter++;
        if (B.value)
            counter++;
        if (Cin.value)
            counter++;

        if(counter>=2)
            return output;
        else {
            output.value = !output.value;
            return output;
        }
    }

}
