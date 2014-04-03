Last updated 4/2/2014 ~5:00 PM PST
GUI uses Aditya Chopra's 2048 implementation as a base and
	has a few modifications. The AI is my own. This version
	will occasionally be updated to reflect Aditya's updates,
	but this won't happen all the time because of said 
	modifications.

To run: compile everything and run GameGUI. Warning: this 
	program may create a LOT of output files. Files of the 
	form AIReplay#.txt are created once every time the AI 
	is started (after finishing all trials it's set to run). 
	Files of the form IndivReplay.txt are created every time
	the AI plays a round. Change the "recording" setting 
	(see below) to disable this.

Adjustable settings (AI.java, static variables):
name: Name of the AI as recorded in the high scores. (scores.txt)
	The usage of this field has been deprecated at least for now.
recording: whether or not the program will output files (game 
	transcripts).
thisAIIsCheating: if true, the AI cheats by creating a the correct
	tile on the board. This may be patched eventually (Aditya has 
	been notified).
dumbai: if true, dumb AI mode is activated. It moves left, left, 
	up, right, right, up, left... with down every so often to 
	prevent getting stuck forever.
iter_max: roughly how many subiterations will be run each time 
	the AI is called (the AI will use recursion; this is roughly
	the number of method calls). AI will run more slowly but may
	perform better for higher values.
worst_weight: How much the AI weights the worst-case scenario 
	versus the average-case scenario, roughly.
asym_greater/asym_lesser: controls how quickly the importance of
	having high tiles in a square dies off as you leave the "root"
	corner. The greater the ratio, the greater the asymmetry in 
	the build.
debug, debug2: For debugging. Will slow down the program and 
	print stuff to the console.

Adjustable settings (GameGUI.java, static variables):
ai: if the AI will run on keypress (assuming that no instance of
	the AI is already running). Adjustable from the GUI.
ai_name: the name of the AI as recorded in high scores during 
	non-autorestart games. Adjustable from the GUI.
ai_autoRestert: controls if the AI will automatically restart after
	each game, until the number of trials is completed. Adjustable
	from the GUI.
ai_trials: if ai_autoRestart is true, this is how many times it 
	will restart until it finishes. Adjustable from the GUI.
win_target: When a tile of this size appears, the game is over.
sleep_time: Time in milliseconds the game sleeps between AI calls.
	If this is too short, the GUI may not update correctly. 
	Adjustable from the GUI.
funky_fonts: if true, smaller numbers will have larger font sizes.

Variables which are listed as adjustable from the GUI can be 
	modified in the AI menu in the GUI when the program is run.
	Changing it in the source code changes the default value, 
	however. 

If a static variable is not mentioned in the above lists, it should
	not be changed (changing it might do nothing or might crash the 
	program).

