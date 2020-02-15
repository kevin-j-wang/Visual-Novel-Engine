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
#Cutscene
<Title of the video file to be played here, including the extension. Example: cutscene4.mp4>
	Plays a prerendered video using the video extensions MP4, which is guaranteed to work. All other formats may work but I cannot guarantee this.
#Sound
<Title of the sound file to be played here, including the extension. Example: soundEffect3.mp3>
	Plays a prerecorded audio file. Appropriate file extensions include: .WAV, .mp3, .AAC, and .AIFF
#Ending
<Message>
	Use this only when ending the game. Displays the provided message in a dramatic way.

PLAYING GAMES: 
Press play. The game will then begin to load in the panels. It will be complete when the buttons disappear. Do not do anything until then. Once the buttons disappear, clicking anywhere will begin the game.