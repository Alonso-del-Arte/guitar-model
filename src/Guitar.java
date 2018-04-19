public class Guitar extends StringedInstrument {

    public static final Corda GUITAR_DEFAULT_CORDA_6 = new Corda();
    public static final Corda GUITAR_DEFAULT_CORDA_5 = new Corda(45);
    public static final Corda GUITAR_DEFAULT_CORDA_4 = new Corda(50);
    public static final Corda GUITAR_DEFAULT_CORDA_3 = new Corda(55);
    public static final Corda GUITAR_DEFAULT_CORDA_2 = new Corda(59);
    public static final Corda GUITAR_DEFAULT_CORDA_1 = new Corda(64);

    public static final Corda GUITAR_DROP_D_TUNING_CORDA_6 = new Corda(38);

    public static final Corda[] GUITAR_DEFAULT_CORDA_SET = {GUITAR_DEFAULT_CORDA_6, GUITAR_DEFAULT_CORDA_5, GUITAR_DEFAULT_CORDA_4, GUITAR_DEFAULT_CORDA_3, GUITAR_DEFAULT_CORDA_2, GUITAR_DEFAULT_CORDA_1};
    public static final Corda[] GUITAR_DROP_D_TUNING_CORDA_SET = {GUITAR_DROP_D_TUNING_CORDA_6, GUITAR_DEFAULT_CORDA_5, GUITAR_DEFAULT_CORDA_4, GUITAR_DEFAULT_CORDA_3, GUITAR_DEFAULT_CORDA_2, GUITAR_DEFAULT_CORDA_1};

    private String identificatoryString = "Guitar";
    private String tuningDescription;

    @Override
    public String toString() {
        return identificatoryString;
    }

    @Override
    public String tuningID() {
        return tuningDescription;
    }

    private String identifyTuning() {
        if (this.getNumberOfStrings() != 6) {
            return "Tuning not recognized.";
        }
        String tuningIDString = "Other tuning.";
        boolean flagADGBE = true;
        int currCorda = 1;
        while (flagADGBE && currCorda < 6) {
            flagADGBE = (CordaSet[currCorda].openPitch == GUITAR_DEFAULT_CORDA_SET[currCorda].openPitch);
            currCorda++;
        }
        if (flagADGBE) {
            if (CordaSet[0].openPitch == GUITAR_DEFAULT_CORDA_6.openPitch) {
                tuningIDString = "Default EADGBE tuning.";
            }
            if (CordaSet[0].openPitch == GUITAR_DROP_D_TUNING_CORDA_SET[0].openPitch) {
                tuningIDString = "Drop D turing";
            }
        }
        return tuningIDString;
    }

    public Guitar() {
        super(GUITAR_DEFAULT_CORDA_SET, 24, 24);
        identificatoryString = "Guitar with default EADGBE tuning";
        tuningDescription = "Default EADGBE tuning";
    }

    public Guitar(Corda[] cordaSet) {
        super(cordaSet, 24, 24);
    }
}