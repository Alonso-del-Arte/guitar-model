public class Corda {

    protected int openPitch;

    public int soundingPitchNumber(int fretNumber) {
        if (fretNumber == -1) {
            return -1;
        } else {
            return (openPitch + fretNumber);
        }
    }

    public void retune(int newOpenPitch) {
        if (newOpenPitch < 21 || newOpenPitch > 96) {
            throw new IllegalArgumentException(newOpenPitch + " is out of acceptable range (21 to 96, or A0 to C7).");
        }
        openPitch = newOpenPitch;
    }

    /**
     * No argument constructor, defaulting to low E guitar string
     */
    public Corda() {
        openPitch = 40;
    }

    public Corda(int initialOpenPitch) {
        if (initialOpenPitch < 21 || initialOpenPitch > 96) {
            throw new IllegalArgumentException(initialOpenPitch + " is out of acceptable range (21 to 96, or A0 to C7).");
        }
        openPitch = initialOpenPitch;
    }
}
