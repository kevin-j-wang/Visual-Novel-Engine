Welcome to Storytime! (Formerly JavaVN) 

This documentation is meant for people who are interested in making Visual Novels using Storytime.
It is very simple. Just use the commands listed below and do not make any spelling mistakes.
Ignore all triangular brackets in this documentation, they are for formatting only. (<,>)
If you want to start your line with the Hashtag symbol "#", use " #" instead. Notice the leading space.
If you make a typo, the game will instead print out an error message at that point in the game, as well as write it out in the console. Do not make a typo.

The first 3 Lines of your file should be as follows:
<Title>
<Author(s)> Remember to keep all authors on one line, format as you wish. Do not make it too long :).
<Date Created>

List of Special Commands:

#BlackTransition
<literally nothing>
	Moves to the next panel after fading to black.
#WhiteTransition
<literally nothing>
	Moves to the next panel after fading to white.
#Cutscene
<Title of the video file to be played here, including the extension. Example: cutscene4.mp4>
	Plays a prerendered video using the video extensions MP4, which is guaranteed to work. All other formats may work but I cannot guarantee this.
#Sound
<Title of the sound file to be played here, including the extension. Example: soundEffect3.mp3>
	Plays a prerecorded audio file. Appropriate file extensions include: .WAV, .mp3, .AAC, and .AIFF
#Choice
<Integer between 0-2147483647>
<Choice #1>
<Choice #2>
<...>
<Choice #2147483647>
	The player is given at least 1 option that they must choose from in order to advance to the next panel. This may or may not affect the next panel. 
	Probably do not go over 6 choices or unexpected results may occur.
	The number of choices MUST BE EQUAL TO THE INTEGER PROVIDED ON THE FIRST LINE
#Ending
<Message>
	Use this only when ending the game. Displays the provided message in a dramatic way.
#ScreenShake
<Integer between 0-2147483647>
	The integer is the magnitude of screen shake. Larger values mean more shaky. Use trial and error to find a good value. 
	Probably do not put 2147483647 as it may shake for a very long period of time.
#ScreenTint
<Integer between 0-2147483647>
<Color>
OR
<Integer between 0-2147483647>
<R, G, B, A> 
	The integer is the length of time the screen's color will be changed. 
	If using color name, look up acceptable color names for java. If using RGBA values, remember that the values range between 0-255. The greater the A value, the more opaque the tint.

