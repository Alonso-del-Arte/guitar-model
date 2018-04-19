public abstract class StringedInstrument {

    Corda[] CordaSet;
    private final int numberOfCorde;
    private final int maxFretNumber;
    protected int genMIDIPatchNumber;
    boolean tuningChanged;

    public int getNumberOfStrings() {
        return numberOfCorde;
    }

    /**
     * Without arguments, this function gives MIDI pitch numbers for the open strings.
     * @return An array of integers corresponding to the MIDI pitch numbers, starting with the lowest strings and going
     * in order to the highest string.
     */
    public int[] pitchArray() {
        int[] pitches = new int[numberOfCorde];
        for (int currCorda = 0; currCorda < numberOfCorde; currCorda++) {
            pitches[currCorda] = CordaSet[currCorda].soundingPitchNumber(0);
        }
        return pitches;
    }

    /**
     * This function gives MIDI pitch numbers for the specified fret pattern.
     * @param fretNumbers An array of fret numbers. May be -1 to indicate the string is skipped over, or 0 to indicate
     *                    that it is open.
     * @return An array of integers of MIDI pitch numbers that can be passed to MIDI devices to indicate pitches.
     * @throws IllegalArgumentException If the supplied fretNumbers array either calls for more strings than the
     * instrument has, or any of the array numbers are greater than the maximum number of frets on the instrument, or if
     * any of those numbers are negative numbers other than -1.
     */
    public int[] pitchArray(int[] fretNumbers) {
        if (fretNumbers.length != numberOfCorde) {
            String exceptionMessage = "Instrument only has " + numberOfCorde + " strings, yet fret pattern calls for " + fretNumbers.length + " strings.\n";
            exceptionMessage = exceptionMessage + "0 may be used to indicate an open string, or -1 to indicate a skipped string.";
            throw new IllegalArgumentException(exceptionMessage);
        }
        int pitches[] = new int[numberOfCorde];
        for (int currCorda = 0; currCorda < numberOfCorde; currCorda++) {
            if (fretNumbers[currCorda] < -1 || fretNumbers[currCorda] > maxFretNumber) {
                String exceptionMessage = "Instrument only has " + maxFretNumber + " frets.";
                throw new IllegalArgumentException(exceptionMessage);
            }
            pitches[currCorda] = CordaSet[currCorda].soundingPitchNumber(fretNumbers[currCorda]);
        }
        return pitches;
    }

    public abstract String tuningID();

    public StringedInstrument(Corda[] CordaArray, int maxFrets, int genMIDIInstrNum) {
        CordaSet = CordaArray;
        numberOfCorde = CordaSet.length;
        maxFretNumber = maxFrets;
        genMIDIPatchNumber = genMIDIInstrNum;
        tuningChanged = false;
    }

}