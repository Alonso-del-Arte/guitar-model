public class Ukulele extends StringedInstrument {

    public static final Corda UKULELE_DEFAULT_CORDA_4 = new Corda(67);
    public static final Corda UKULELE_DEFAULT_CORDA_3 = new Corda(60);
    public static final Corda UKULELE_DEFAULT_CORDA_2 = new Corda(64);
    public static final Corda UKULELE_DEFAULT_CORDA_1 = new Corda(69);

    public static final Corda UKULELE_NONREENTRANT_TUNING_CORDA_4 = new Corda(55);

    public static final Corda[] UKULELE_DEFAULT_CORDA_SET = {UKULELE_DEFAULT_CORDA_4, UKULELE_DEFAULT_CORDA_3, UKULELE_DEFAULT_CORDA_2, UKULELE_DEFAULT_CORDA_1};
    public static final Corda[] UKULELE_NONREENTRANT_TUNING_CORDA_SET = {UKULELE_NONREENTRANT_TUNING_CORDA_4, UKULELE_DEFAULT_CORDA_3, UKULELE_DEFAULT_CORDA_2, UKULELE_DEFAULT_CORDA_1};

    private String identificatoryString = "Ukulele";

    @Override
    public String toString() {
        return identificatoryString;
    }

    @Override
    public String tuningID() {
        return "tuningID function not yet implemented. First test will fail.";
    }

    public Ukulele() {
        super(UKULELE_DEFAULT_CORDA_SET, 20, 105);
        identificatoryString = "Ukulele with default re-entrant GCEA tuning";
    }

    public Ukulele(Corda[] cordaSet) {
        super(cordaSet, 20, 105);
    }
}
