import java.awt.event.*;
import java.util.*;
import java.io.*;
public class AI {
	public static final String VERSION = "1.1.5";
	public static String name = "WerryJu";
	public static int trials = 20;
	public static boolean autoRestart = true;
	private static LinkedList<Integer> queue = new LinkedList<Integer>();
	private static boolean dumbai = false;
	private static Scanner sc = new Scanner(System.in);
	private static int turn = 0;
	private static boolean debug = false;
	private static boolean debug2 = false;
	private static boolean recording = true;
	private static boolean thisAIIsCheating = false;
	public static PrintWriter out = null;
	private static int max_depth = 0;
	private static int iter_max = 30000;
	public static String filename;
	public static int ai_move (int[][] board) {
		//System.out.println(2 + Math.random());
		if (recording) {
			if (out == null) {
				try {
					int ind = 1;
					File f = null;
					while (true) {
						try {
							Scanner sc = new Scanner(new File("AIReplay" + ind + ".txt"));
							ind++;
						} catch (Exception e) {
							break;
						}
					}
					out = new PrintWriter(new File("AIReplay" + ind + ".txt"));
					filename = "AIReplay" + ind + ".txt";
					out.println("AI Version: " + VERSION);
				} catch (Exception e) {
					System.out.println("Could not write to file.");
				}
			}
			fprint(board);
		}
		if (thisAIIsCheating) board[0][0] = 2048;
		if (debug2) sc.nextLine();
		if (debug2) print(board);
		if (debug) System.out.println("New cycle.");
		if (debug) sc.nextLine();
		if (dumbai && !name.matches("*Dumby")) name += "Dumby";
		turn++;
		if (!queue.isEmpty()) {
			int temp = queue.removeFirst();
			if (temp > 0) return temp;
		}
		boolean report = debug;
		/*if (Math.random() < 0.0001) {
		report = true;
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(movable(board, i));
		}
		System.out.println();
		sc.nextLine();
		}*/
		if (dumbai) {	
			System.out.println(turn);
			if (turn % 600 == 2) return KeyEvent.VK_DOWN;
			if (turn % 3 == 0) return KeyEvent.VK_UP;
			if (turn % 6 < 3) return KeyEvent.VK_LEFT;
			return KeyEvent.VK_RIGHT;
		}
		//gamestart processing
		/*if(board[0][0] == 0) {
			if (board[1][0] > board[0][1]) {
				return KeyEvent.VK_UP;
			} 
			if (board[1][0] < board[0][1]) {
				return KeyEvent.VK_LEFT;
			}
			if (Math.random() < 0.5) return KeyEvent.VK_UP;
			return KeyEvent.VK_LEFT;
		}*/
		long[] pref = {10, 20, 1, 1}; // LEFT, UP, RIGHT, DOWN
		
		//check if moving right/down is safe
		boolean occupied = true;
		
		for (int i = 0; i < 4; i++) {
			if (board[0][i] == 0) occupied = false;
			if (i < 3 && board[0][i] == board[0][i + 1]) occupied = false;
		}
		if (!occupied) {
			//pref[2] -= 100000000;
		}
		occupied = true;
		for (int i = 0; i < 4; i++) {
			if (board[i][0] == 0) occupied = false;
			if (i < 3 && board[i][0] == board[i + 1][0]) occupied = false;
		}
		if (!occupied) {
			//pref[3] -= 100000000;
		}
		
		pref[0] += 5;
		pref[1] += 5;
		
		//System.out.println(6 + Math.random());
		//simulate
		if (debug) print(board);
		max_depth = 0;
		for (int m = 0; m < 4; m++) {
			if (debug) System.out.println("Now testing move: " + m);
			int[][] sim = simulate(board, m);
			if (Arrays.deepEquals(sim, board)) {
				out.println("Move " + m + " invalid; skipping");
				continue;
			}
			long worst = (long) 1999999999 * 100000000;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (sim[i][j] > 0) continue;
					sim[i][j] = 2;
					long temp = predictor(sim, iter_max/(int) pow((countBlank(sim) + 1), 2), 1);
					if (temp < worst) worst = temp;
					sim[i][j] = 4;
					temp = predictor(sim, iter_max/(int) pow((countBlank(sim) + 1), 2), 1);
					if (temp < worst) worst = temp;
					sim[i][j] = 0;
				}
			}
			if (worst == (long) 1999999999 * 100000000) {
				long temp = predictor(sim, iter_max/(int) pow((countBlank(sim) + 1), 2), 1);
				if (temp < worst) worst = temp;
			}
			if (debug || debug2) System.out.println("Move " + m + " final eval: " + worst);
			out.println("Move " + m + " final eval: " + worst);
			pref[m] += worst;
		}
		if (debug2) System.out.println("Max depth: " + max_depth);
		out.println("Max depth: " + max_depth);
		
		//System.out.println(5 + Math.random());
		//process output
		int[] dir = new int[4];
		dir[0] = KeyEvent.VK_LEFT;
		dir[1] = KeyEvent.VK_UP;
		dir[2] = KeyEvent.VK_RIGHT;
		dir[3] = KeyEvent.VK_DOWN;
		if (report) System.out.println("Pref: " + Arrays.toString(pref));	
		for (int i = 0; i < 4; i++) {
			int best = 0;
			for (int j = 0; j < 4; j++) {
				if (pref[j] > pref[best]) {
					best = j;
				}
			}
			pref[best] = Long.MIN_VALUE;
			if (movable(board, best)) {
				if (report) {
					report = false;
					if (debug) System.out.println("Chosen: " + best);
					if (debug) sc.nextLine();
				}
				//if (pref[best] < -50000000) queue.add(best - 2);
				return dir[best];
			}
			//System.out.println("Unmovable: " + best);
			//System.out.println("Pref: " + Arrays.toString(pref));
		}
		System.out.println("???");
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		//sc.nextLine();
		return KeyEvent.VK_LEFT;
	}
	
	public static long predictor(int[][] board, int iters, int depth) { //returns future value, kinda
		//System.out.println(Math.random());
		if (depth > max_depth) max_depth = depth;
		//if (max(board) < 64 && depth == 1) return grade(board);
		int div = 0;
		for (int i = 0; i < 4; i++) {
			int[][] sim = simulate(board, i);
			if (Arrays.deepEquals(sim, board)) continue;
			div += countBlank(sim);
		}
		if (!movable(board, 0) && !movable(board, 1) && !movable(board, 2) && !movable(board, 3)) return (long) -1999999999 * 1000000;
		div *= 2;
		if (div > iters) return grade(board);
		iters /= div;
		long best = (long) -1999999999*8000000;
		if (debug) print(board);
		for (int m = 0; m < 4; m++) {
			int[][] sim = simulate(board, m);
			if (Arrays.deepEquals(sim, board)) continue;
			if (debug) System.out.println("Simulating: " + m);
			long worst = (long) 1999999999*8000000;
			long avg = 0;
			int numt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (sim[i][j] > 0) continue;
					sim[i][j] = 2;
					long temp = predictor(sim, iters, depth + 1);
					if (temp < worst) worst = temp;
					avg += temp;
					sim[i][j] = 4;
					temp = predictor(sim, iters, depth + 1);
					if (temp < worst) worst = temp;
					avg += temp;
					sim[i][j] = 0;
					numt+=2;
				}
			}
			if (worst == (long) 1999999999 * 8000000) {
				long temp = predictor(sim, iter_max/(int) pow((countBlank(sim) + 1), 2), 1);
				if (temp < worst) worst = temp;
				avg += temp;
				numt++;
			}
			//avg -= worst;
			avg /= numt;
			if (debug) System.out.println("Result: " + worst);
			if ((avg + 5 * worst) / 6 > best) best = (5 * worst + avg) / 6;
			if (worst > best) best = worst;
			if (div >= 64 && max(board) < 64 && avg > best) best = avg; 
		}
		return best;
	}
	public static int[][] simulate(int[][] board, int direction) {
		//Scanner sc = new Scanner(System.in);
		//print(board);
		//System.out.println(direction);
		int[][] out = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				out[i][j] = board[i][j];
			}
		}
		if (direction % 2 == 1) transpose(out); // everything is left or right
		if (direction / 2 == 1) flip(out); // everything is left
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (out[i][j] == 0) {
					int index = j;
					for (int k = j + 1; k < 4; k++) {
						if (out[i][k] > 0) {
							out[i][index] = out[i][k];
							out[i][k] = 0;
							index++;
						}
					}
				}
				if (out[i][j] == out[i][j + 1]) {
					out[i][j] *= 2;
					out[i][j + 1] = 0;
				}
			}
		}		
		if (direction / 2 == 1) flip(out); // undo!
		if (direction % 2 == 1) transpose(out); // undo!
		//print(out);
		//sc.nextLine();
		return out;
	}
	public static long grade(int[][] board) {	
		//System.out.println(1 + Math.random());
		if (debug) System.out.println("Graded: ");
		if (debug) print(board);
		if (max(board) >= GameGUI.WIN_TARGET) return (long) 1999999999 * 900000;
		//if (turn < 12 && board[0][0] < Math.min(board[0][1], board[1][0])) return -999999999;
		long val = 0;
		//sums
		//System.out.println(9 + Math.random());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = 0;
				for (int k = 0; k < j; k++) {
					if (board[i][k] > 0) num++;
					num++;
				}
				for (int k = 0; k < i; k++) {
					if (board[k][j] > 0) num++;
					num+=2;
				}
				num = num * 2 /3;
				num = 12 - num;
				val += (long) (pow(2, num) - 3072/(long) Math.sqrt(max(board))) * pow(board[i][j], 3) / 100; // roughly delta = 200 * num^2
			}
		}
		if (countBlank(board) > 0) {
			val -= 10000/pow(countBlank(board), 3) * max(board);
		} else {
			val -= 120000 * max(board);
		}
		//bad joints
		//System.out.println(8 + Math.random());
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int max1 = 0;
				for (int k = 1; k < 4 - i; k++) {
					if (board[i + k][j] > max1) max1 = board[i + k][j];
				}
				int max2 = 0;
				for (int k = 1; k < 4 - j; k++) {
					if (board[i][j + k] > max2) max2 = board[i][j + k];
				}
				max1 = max2 + max2;
				max2 = Math.min(max2, max1-max2);
				max1 -= max2;
				if (board[i][j] > 0 && board[i][j] < max1) 
					val -= (pow(max1 - board[i][j], 3) + pow(max1 / board[i][j] - 1, 4)) * pow(2, 13 - 3 * i / 2 - j) / 120;
				if (board[i][j] > 0 && board[i][j] < max2)
					val -= (pow(max2 - board[i][j], 3) + pow(max2 / board[i][j] - 1, 4)) * pow(2, 13 - 3 * i / 2 - j) / 30;
			}
		}
		
		//System.out.println(10 + Math.random());
		val -= 1200000 * (long) (max(board) - board[0][0]) * Math.pow(max(board), 3);
		if (board[0][0] > 0 && board[0][0] < 8 && max(board) > board[0][0]) val -= 10000000 * max(board);
		if (Math.max(board[0][1], board[1][0]) > 0 && max(board) > 16)val -= 300 * (long) Math.max(0, max2(board) - Math.max(board[0][1], board[1][0])) * pow(max2(board), 2);
		if (debug) System.out.println("Result: " + val);
		if (debug) sc.nextLine();
		//System.out.println(7 + Math.random());
		return val;
	}
	//aux
	public static int rank(int[][] board, int val) {
		int out = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > val) out++;
			}
		}
		return out;
	}
	public static int max(int[][] board) {
		int max = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > max) max = board[i][j];
			}
		}
		return max;
	}
	public static int max2(int[][] board) {
		int max = 0;
		int sec = -1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > max) {
					sec = max;
					max = board[i][j];
				} else if (board[i][j] > sec) sec = board[i][j];
			}
		}
		return sec;
	}
	public static long pow(int b, int e) {
		long out = 1;
		for (int i = 0; i < e; i++) {
			out *= b;
		}
		return out;
	}
	public static int countBlank(int[][] board) {
		int out = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] == 0) out++;
			}
		}
		return out;
	}
	public static void transpose(int[][] board) {
		for (int i = 0; i < 4; i++) {
			for (int j = i; j < 4; j++) {
				int temp = board[i][j];
				board[i][j] = board[j][i];
				board[j][i] = temp;
			}
		}
	}
	public static void flip(int[][] board) {
		//flips horizontally
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				int temp = board[i][j];
				board[i][j] = board[i][3 - j];
				board[i][3 - j] = temp;
			}
		}
	}
	public static void print(int[][] arr) {
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	public static void fprint(int[][] arr) {
		for (int i = 0; i < 4; i++) {	
			out.println(Arrays.toString(arr[i]));
		}
	}
	public static String translate(int id) {	
		if (id == KeyEvent.VK_DOWN) return "DOWN";
		if (id == KeyEvent.VK_UP) return "UP";
		if (id == KeyEvent.VK_LEFT) return "LEFT";
		if (id == KeyEvent.VK_RIGHT) return "RIGHT";
		return "INVALID_ID";
	}
	public static boolean movable(int[][] board, int direction) {
		switch (direction) {
			case 0: 
				for (int i = 0; i < 4; i++) {
					boolean ready = false;
					for (int j = 0; j < 4; j++) {
						if (board[i][j] == 0) {
							ready = true;
						} else {			
							if (j < 3 && board[i][j] == board[i][j + 1]) return true;			
							if (ready) return true;
						}
					}
				}
				break;
			case 1:
				for (int i = 0; i < 4; i++) {
					boolean ready = false;
					for (int j = 0; j < 4; j++) {
						if (board[j][i] == 0) {
							ready = true;
						} else {				
							if (j < 3 && board[j][i] == board[j + 1][i]) return true;		
							if (ready) return true;
						}
					}
				}
				break;
			case 2:
				for (int i = 0; i < 4; i++) {
					boolean ready = false;
					for (int j = 3; j >= 0; j--) {
						if (board[i][j] == 0) {
							ready = true;
						} else {		
							if (j < 3 && board[i][j] == board[i][j + 1]) return true;				
							if (ready) return true;
						}
					}
				}
				break;
			case 3:
				for (int i = 0; i < 4; i++) {
					boolean ready = false;
					for (int j = 3; j >= 0; j--) {
						if (board[j][i] == 0) {
							ready = true;
						} else {		
							if (j < 3 && board[j][i] == board[j + 1][i]) return true;				
							if (ready) return true;
						}
					}
				}
				break;
			default:
				return false;
		}
		return false;
	}
}