Last updated 3/27s/2014 ~10:45 AM PST
GUI uses Aditya Chopra's 2048 implementation as a base and has a few modifications. The AI is my own. This version will occasionally be updated to reflect Aditya's updates, but this won't happen all the time because of said modifications.

To run: compile everything and run GameGUI. Warning: this program may create a LOT of output files. Files of the form AIReplay#.txt are created once every time the AI is started (after finishing all trials it's set to run). Files of the form IndivReplay.txt are created every time the AI plays a round.

Adjustable settings (AI.java, static variables):
name: Name of the AI as recorded in the high scores. (scores.txt)
trials: Number of trials to run, provided autoRestart is true.
autoRestart: Activates the running of multiple trials. High scores may not be recorded.
recording: whether or not the program will output files (game transcripts).
thisAIIsCheating: if true, the AI cheats by creating a 2048 tile on the board. This may be patched eventually (Aditya has been notified).
dumbai: if true, dumb AI mode is activated. It moves left, left, up, right, right, up, left... with down every so often to prevent getting stuck forever.
iter_max: roughly how many subiterations will be run each time the AI is called (the AI will use recursion; this is roughly the number of method calls). AI will run more slowly but may perform better for higher values.
worst_weight: How much the AI weights the worst-case scenario versus the average-case scenario, roughly.
debug, debug2: For debugging. Will slow down the program and print stuff to the console.

Adjustable settings (GameGUI.java, static variables):
win_target: When a tile of this size appears, the game is over.
sleep_time: Time in milliseconds the game sleeps between AI calls. If this is too short, the GUI may not update correctly.

If a static variable is not mentioned in the above lists, it should not be changed (changing it might do nothing or might crash the program).

