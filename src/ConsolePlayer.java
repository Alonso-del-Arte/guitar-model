import javax.sound.midi.*;

public class ConsolePlayer {

    public static final int DEFAULT_MIDI_VELOCITY = 93;
    public static final int DEFAULT_CHANNEL = 0;

    private long timeStampForOnMessages, getTimeStampForOffMessages;

    public static void soundOpenStrings(StringedInstrument stringedInstrument, MidiChannel midiChannel) {
        int[] pitchNumbers = stringedInstrument.pitchArray();
        int patchNumber = stringedInstrument.genMIDIPatchNumber;
        for (int pitch : pitchNumbers) {
                midiChannel.noteOn(pitch, DEFAULT_MIDI_VELOCITY);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.exit(-1);
        }
        midiChannel.allNotesOff();
    }

    public static void main(String[] args) {
        System.out.println("Open strings demo");
        StringedInstrument strInstr = new Guitar();
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel channel = synth.getChannels()[0];
            channel.programChange(strInstr.genMIDIPatchNumber);
            System.out.println("Open strings on " + strInstr.toString());
            soundOpenStrings(strInstr, channel);
            strInstr = new Guitar(Guitar.GUITAR_DROP_D_TUNING_CORDA_SET);
            System.out.println("Open strings on " + strInstr.toString());
            soundOpenStrings(strInstr, channel);
            strInstr = new Ukulele();
            System.out.println("Open strings on " + strInstr.toString());
            soundOpenStrings(strInstr, channel);
            strInstr = new Ukulele(Ukulele.UKULELE_NONREENTRANT_TUNING_CORDA_SET);
            System.out.println("Open strings on " + strInstr.toString());
            soundOpenStrings(strInstr, channel);
            synth.close();
        } catch (MidiUnavailableException muae) {
            System.out.println("Sorry, no MIDI device available. " + muae.getMessage());
            System.exit(-1);
        }
        System.out.println("Demo complete.");
    }

}
