import java.awt.event.*;
import java.util.*;
import java.io.*;
public class AI {
	//Meta-Settings
	public static final String VERSION = "1.4.7";
	public static String name = "WerryJu";
	public static int trials = 50;
	public static boolean autoRestart = true;
	public static boolean recording = true;
	private static boolean thisAIIsCheating = false;
	
	//Performance/Algorithm Settings
	private static boolean dumbai = false;
	private static int iter_max = 50000;
	private static int worst_weight = 3; // worst is weighted weight:1 vs avg
	private static int asym_weight = 5; // dist from "heavier" edge is weighted weight:1 (see grade())
	
	//Debug Settings
	private static boolean debug = false;
	private static boolean debug2 = false;
	
	//Data Storage (don't touch)
	private static LinkedList<Integer> queue = new LinkedList<Integer>();
	private static Scanner sc = new Scanner(System.in);
	private static int turn = 0;
	public static PrintWriter out = null;
	public static PrintWriter fml = null;
	private static int max_depth = 0;
	public static String filename = "no output";
	public static long debnum = 0; // debug
	
	public static int ai_move (int[][] board) {
		try {
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
		//if (fml == null) fml = new PrintWriter (new File("fmldebug.txt"));
		if (thisAIIsCheating && max(board) < 8) {
			board[0][0] = 2048;
		}
		if (debug2) sc.nextLine();
		if (debug2) print(board);
		if (debug) System.out.println("New cycle.");
		if (debug) sc.nextLine();
		if (dumbai) name += "Dumby";
		turn++;
		if (!queue.isEmpty()) {
			int temp = queue.removeFirst();
			if (temp > 0) return temp;
		}
		int boardsum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				boardsum += board[i][j];
			}
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
			if (turn % 600 == 599) return KeyEvent.VK_DOWN;
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
			if (debug) 
				System.out.println("Now testing move: " + m);
			int[][] sim = simulate(board, m);
			if (Arrays.deepEquals(sim, board)) {
				if (out != null) out.println("Move " + m + " invalid; skipping");
				if (GameGUI.out != null) GameGUI.out.println("Move " + m + " invalid; skipping");
				continue;
			}
			long worst = (long) 1999999999 * 1000000000;
			long avg = 0;
			int numt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (sim[i][j] > 0) continue;
					sim[i][j] = 2;
					long temp = predictor(sim, iter_max/(int) Math.pow((countBlank(sim) + 1), 1.6), 1);
					if (temp < worst) worst = temp;
					avg += 9 * temp;
					sim[i][j] = 4;
					temp = predictor(sim, iter_max/(int) Math.pow((countBlank(sim) + 1), 1.6), 1);
					if (temp < worst) worst = temp;
					avg += temp;
					sim[i][j] = 0;
					numt += 10;
				}
			}
			if (countBlank(sim) == 0) {
				long temp = predictor(sim, iter_max/(int) pow((countBlank(sim) + 1), 2), 1);
				if (temp < worst) worst = temp;
				avg += temp;
				numt++;
			}
			avg /= numt;
			worst = (worst_weight * worst + avg) / (worst_weight + 1);
			if (countBlank(sim) >= 8 && max(board) < 64) worst = avg;
			if (debug || debug2) System.out.println("Move " + m + " final eval: " + worst);
			if (out != null) out.println("Move " + m + " final eval: " + worst);
			if (GameGUI.out != null) GameGUI.out.println("Move " + m + " final eval: " + worst);
			pref[m] += worst;
		}
		if (debug2) System.out.println("Max depth: " + max_depth);
		if (out != null) out.println("Max depth: " + max_depth);
		if (GameGUI.out != null) GameGUI.out.println("Max depth: " + max_depth);
		
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return KeyEvent.VK_LEFT;
	}
	
	public static long predictor(int[][] board, int iters, int depth) { //returns future value, kinda
		//debnum+=4;
		//System.out.println(Math.random());
		if (depth > max_depth) max_depth = depth;
		//if (max(board) < 64 && depth == 1) return grade4(board);
		int div = 0;
		for (int i = 0; i < 4; i++) {
			int[][] sim = simulate(board, i);
			if (Arrays.deepEquals(sim, board)) continue;
			div += countBlank(sim);
		}
		if (!movable(board, 0) && !movable(board, 1) && !movable(board, 2) && !movable(board, 3)) {
			//if (max(board) == GameGUI.win_target) return grade(board);
			return (long) -1999999999 * 1000000;
		}
		div *= 2;
		if (div > iters) {
			//debnum-=4;
			return grade4(board);
		}
		iters /= div;
		long best = (long) -1999999999*800000000;
		if (debug) print(board);
		
		
		for (int m = 0; m < 4; m++) {
			//debnum--;
			int[][] sim = simulate(board, m);
			if (Arrays.deepEquals(sim, board)) continue;
			if (debug) System.out.println("Simulating: " + m);
			long worst = (long) 1999999999*800000000;
			long avg = 0;
			int numt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (sim[i][j] > 0) continue;
					sim[i][j] = 2;
					long temp = predictor(sim, iters, depth + 1);
					if (temp < worst) worst = temp;
					avg += 9 * temp;
					sim[i][j] = 4;
					temp = predictor(sim, iters, depth + 1);
					if (temp < worst) worst = temp;
					avg += temp;
					sim[i][j] = 0;
					numt+=10;
				}
			}
			if (countBlank(sim) == 0) {
				//System.out.println("??");
				long temp = predictor(sim, iter_max/(int) pow((countBlank(sim) + 1), 2), depth + 1);
				if (temp < worst) worst = temp;
				avg += temp;
				numt++;
			}
			//avg -= worst;
			avg /= numt;
			if (debug) System.out.println("Result: " + worst);
			if ((avg + worst_weight * worst) / (worst_weight + 1) > best) best = (worst_weight * worst + avg) / (worst_weight + 1);
			//if (worst > best) best = worst;
			if (div >= 64 && max(board) < 64 && avg > best) best = avg; 
		}
		return best;
	}
	
	public static long grade4(int[][] board) {// finds best corner to grade from
		int loc = maxfind(board);
		int bcorner = 0;
		if (board[0][3] > board[0][0]) bcorner = 3;
		if (board[3][0] > board[0][bcorner]) bcorner = 30;
		if (board[3][3] > board[bcorner / 10][bcorner % 10]) bcorner = 33;
		if (loc % 10 > 1) flip(board);
		if (loc / 10 > 1) flipv(board);
		long high = grade(board);
		if (loc / 10 > 1) flipv(board);
		if (loc % 10 > 1) flip(board);
		if ((bcorner % 10) / 2 == (loc % 10) / 2 && bcorner / 10 / 2 == loc / 10 / 2) return high;
		if (bcorner % 10 > 1) flip(board);
		if (bcorner / 10 > 1) flipv(board);
		long corn = grade(board);
		if (bcorner / 10 > 1) flipv(board);
		if (bcorner % 10 > 1) flip(board);
		if (high > corn) return high;
		return corn;
	}
		
	public static long grade(int[][] board) {	
		//System.out.println(1 + Math.random());
		if (debug) System.out.println("Graded: ");
		if (debug) print(board);
		int max_board = max(board);
		if (max_board >= GameGUI.win_target) return (long) 1999999999 * 200 * max_board;
		int max2_board = max2(board);
		int sum_board = sum(board);
		int p, q;
		long val = 0;
		if (max_board != board[0][0]) {
			if (4 * board[0][1] + board[0][2] < 4 * board[1][0] + board[2][0]) {
				p = 1;
				q = 2;
			} else {
				p = 2;
				q = 1;
			}
		} else {
			if (4 * board[0][1] + board[0][2] < 4 * board[1][0] + board[2][0]) {
				p = 1;
				q = asym_weight;
				if (locked2(board)) val += 2000 * board[0][0];
			} else {
				p = asym_weight;
				q = 1;
				if (locked(board)) val += 2000 * board[0][0];
			}
		}
		//if (turn < 12 && board[0][0] < Math.min(board[0][1], board[1][0])) return -999999999;
		//sums
		//System.out.println(9 + Math.random());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = p * i + q * j;
				for (int k = 0; k < j; k++) {
					if (board[i][k] > 0) num++;
				}
				for (int k = 0; k < i; k++) {
					if (board[k][j] > 0) num++;
				}
				num = 12 - num * 2 /3;
				val += (long) (pow(2, num) - 384/(long) Math.sqrt(max_board)) * pow(board[i][j], 3 - (p * i + q * j) / (p + q)) / 100; 
			}
		}
		if (countBlank(board) > 0) {
			val -= 10000/pow(countBlank(board), 3) * max_board;
		} else {
			val -= 120000 * max_board;
		}
		int r = (2 * p + q) / 3;
		int s = (p + 2 * q) / 3;
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
				long pwr = pow(2, 14 - r * i - s * j);
				if (board[i][j] > 0 && board[i][j] < max1) 
					val -= (pow(max1 - board[i][j], 1) + pow(max1 / board[i][j] - 1, 1)) * pwr * pow(sum_board, 1) * 2;
				if (board[i][j] > 0 && board[i][j] < max2)
					val -= (pow(max2 - board[i][j], 1) + pow(max2 / board[i][j] - 1, 1)) * pwr * pow(sum_board, 1) * 5;
			}
		}
		
		//System.out.println(10 + Math.random());
		if (max_board > board[0][0]) {
			val -= 1200000 * (long) (sum_board / 2 - board[0][0]) * pow(sum_board / 2, 2);
		}
		if (board[0][0] < 8 && board[0][0] > 0 && max_board > board[0][0]) val -= 100000000 / board[0][0];
		if ((board[0][1] > 0 || board[1][0] > 0) && max_board > 16)
			val -= 3000 * (long) Math.max(0, max2_board - Math.max(board[0][1], board[1][0])) * pow(sum_board / 4, 3);
		if (debug) System.out.println("Result: " + val);
		if (debug) sc.nextLine();
		//if (4 * board[0][1] + board[0][2] < 4 * board[1][0] + board[2][0]) transpose(board);
		//System.out.println(7 + Math.random());
		return val;
	}
	
	//aux
	
	public static boolean locked(int[][] board) {	
		for (int i = 0; i < 4; i++) {
			if (board[0][i] == 0) return false;
		}
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[0][i + 1]) return false;
		}
		return true;
	}
	public static boolean locked2(int[][] board) {	
		for (int i = 0; i < 4; i++) {
			if (board[i][0] == 0) return false;
		}
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i + 1][0]) return false;
		}
		return true;
	}
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
	public static int maxfind(int[][] board) { // returns 10 * i + j
		int r = 0;
		int c = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > board[r][c]) {
					r = i;
					c = j;
				}
			}
		}
		return 10 * r + c;
	}
	public static int sum(int[][] board) {
		int out = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				out += board[i][j];
			}
		}
		return out;
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
			for (int j = i + 1; j < 4; j++) {
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
	public static void flipv(int[][] board) {
		//flips vertically
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				int temp = board[i][j];
				board[i][j] = board[3 - i][j];
				board[3-i][j] = temp;
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
	public static int[][] simulate(int[][] board, int direction) {
		//Scanner sc = new Scanner(System.in);
		//print(board);
		//System.out.println(direction);
		//fml.println(10);
		int[][] out = new int[4][];
		for (int i = 0; i < 4; i++) {
			out[i] = Arrays.copyOf(board[i], 4);
		}
		if (direction % 2 == 1) transpose(out); // everything is left or right
		if (direction / 2 == 1) flip(out); // everything is left
		for (int i = 0; i < 4; i++) {
			int index = 0;
			for (int j = 1; j < 4; j++) {
				if (out[i][j] == 0) continue;
				if (out[i][index] == 0) {
					out[i][index] = out[i][j];
					out[i][j] = 0;
				} else if (out[i][index] == out[i][j]) {
					out[i][index] *= 2;
					out[i][j] = 0;
					index++;
				} else {
					index++;
					if (index == j) continue;
					out[i][index] = out[i][j];
					out[i][j] = 0;
				}
			}
		}
					
		if (direction / 2 == 1) flip(out); // undo!
		if (direction % 2 == 1) transpose(out); // undo!
		//print(out);
		//sc.nextLine();
		//fml.println(11);
		return out;
	}
}