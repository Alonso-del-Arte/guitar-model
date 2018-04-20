# guitar-model
STUDENT EXERCISE: An exercise on abstract classes in which different stringed instruments, preferably fretted, are derived from an abstract super class. The fact that this model focuses on is that stringed instruments, like guitars, have a small number of strings (generally six, sometimes twelve and sometimes even just three), which places certain limitations on what can be played, limitations that are not always reflected in music software.

For example, look at the following chord:

<img src="https://github.com/Alonso-del-Arte/guitar-model/blob/master/C7%20chord%20example.jpg" alt="C7 chord example" />

On the piano, it's trivially simple to play this chord exactly as written. The image is a screenshot from Make Music Finale, a music notation program that's been around for more than twenty years now.

On the guitar, however, a chord like the one shown above presents several difficulties. This even though it's only six notes and they all seem to be in the guitar's range.

If we understand the lowest E as meant for the guitar's lowest string in the default tuning, then we immediately run into the problem that the next higher note can only be played on the very same string that we are already expecting to play the lowest note on. In any case, F major is not a terribly good key for the guitar.

In programs like Finale, we can easily set the computer playback to use a synthesized or sampled guitar for playback, and we could fool ourselves into thinking that what we heard the computer play is something that can actually be played on a real guitar.

By modelling what the strings of the instrument are, the computer can achieve a somewhat more realistic representation of the sound of a stringed instrument.
