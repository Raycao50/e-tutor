import java.util.*;
import static java.lang.System.out;

@SuppressWarnings({"unchecked"})
public class Bestfirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BestFirstSearch.java
		// Demonstrates best-first search using java.util.PriorityQueue
		// Also demonstrates the need for a custom hashCode and equals method.
		// Includes a (not-so-great) implementation of
		// the famous Nine Puzzle.
				NinePuzzle np = NinePuzzle.makeRandomPuzzle(10);
				np.print();

				out.println("\n----\nSolving with a BREADTH-FIRST Queue");
				solve(new NinePuzzle(np),new LinkedList<NinePuzzle>(), false);

				out.println("\n----\nSolving with a UNIQUE BREADTH-FIRST Queue");
				solve(new NinePuzzle(np),new LinkedList<NinePuzzle>(), true);

				out.println("\n----\nSolving with a BEST-FIRST PriorityQueue");
				solve(new NinePuzzle(np),new PriorityQueue<NinePuzzle>(), false);

				out.println("\n----\nSolving with a UNIQUE BEST-FIRST PriorityQueue");
				solve(new NinePuzzle(np),new PriorityQueue<NinePuzzle>(), true);
			}
			
			public static void solve(NinePuzzle np, Queue<NinePuzzle> q, boolean useHashSet) {
				int nodesRemoved = 0, nodesAdded = 0;
				HashSet<NinePuzzle> hashset = null;
				if (useHashSet) hashset = new HashSet<NinePuzzle>();
				if (np.getScore() == 0) {
					out.println("PUZZLE WAS ALREADY SOLVED!");
					return;
				}
				q.add(np);
				if (useHashSet) hashset.add(np);
				while (true) {
					if (q.isEmpty()) {
						out.println("NO SOLUTION!");
						break;
					}
					NinePuzzle p = q.remove();
					nodesRemoved++;
					for (NinePuzzle.Move move : NinePuzzle.Move.values()) {
						NinePuzzle child = p.move(move);
						if ((child != null) &&
						    ((!useHashSet) || (!hashset.contains(child)))) {
							if (child.getScore() == 0) {
								out.printf("SOLVED after adding %d nodes and removing %d nodes\n",
								           nodesAdded, nodesRemoved);
								child.printMoves();
								return;
							}
							nodesAdded++;
							q.add(child);
							if (useHashSet) hashset.add(child);
						}
					}
				}
			}
		}

		class NinePuzzle implements Comparable {
			private static final int EMPTY = 8;
			public enum Move { up, down, left, right };
			private static final Random random = new Random();
			private NinePuzzle previous = null;
			public int moves = 0; // count of moves to get to this position
			public Move move;      // direction of move to this position
			private int size = 3;
			private int emptyRow, emptyCol;
			private int[][] board;
			private int score = 1;
			
			// Print this NinePuzzle
			public void print() {
				for (int row=0; row<size; row++) out.printf("---");
				out.println();
				for (int row=0; row<size; row++) {
					for (int col=0; col<size; col++)
						out.printf("%2d ",board[row][col]);
					out.println();
				}
				if (this.moves > 0) printMoves();
			}

			public void printMoves() {
				out.printf("%d moves: ",this.moves);
				Stack<Move> stack = new Stack<Move>();
				for (NinePuzzle p = this; p.move != null; p = p.previous)
					stack.push(p.move);
				while (!stack.isEmpty())
					out.printf("%s ",stack.pop().toString());
				out.println();
			}

			// Use the score to compare two NinePuzzles
			public int compareTo(Object obj) {
				NinePuzzle that = (NinePuzzle)obj;
				return this.getScore() - that.getScore();
			}
			
			public int hashCode() {
				int hashCode = 1;
				for (int row=0; row<size; row++)
				for (int col=0; col<size; col++)
					hashCode = 31*hashCode + board[row][col];
				return hashCode;
			}

			public boolean equals(Object obj) {
				NinePuzzle that = (NinePuzzle) obj;
				for (int row=0; row<size; row++)
				for (int col=0; col<size; col++)
					if (this.board[row][col] != that.board[row][col])
						return false;
				return true;
			}

			// find the score of this nine puzzle -- this is the sum of 
			// the manhattan distances from each piece to where it ultimately
			// belongs
			public int getScore() {
				if (this.score < 0) {
					// have not computed the score yet, so do it now
					this.score = 0;
					for (int row=0; row<size; row++)
					for (int col=0; col<size; col++) {
						int piece = board[row][col];
						if (piece != EMPTY) {
							int targetRow = piece / size;
							int targetCol = piece % size;
							this.score += Math.abs(row - targetRow) +
							              Math.abs(col - targetCol);
						}
					}
				}
				// return cached score
				return this.score;
			}

			// create a new solved nine puzzle
			public NinePuzzle() {
				board = new int[size][size];
				for (int row=0; row<size; row++)
				for (int col=0; col<size; col++)
					board[row][col] = size*row + col;
				board[size-1][size-1] = EMPTY;
				emptyRow = emptyCol = size-1;
			}

			// create a clone of this puzzle, then make the given move
			public NinePuzzle(NinePuzzle p) {
				this.previous = p;
				this.moves = p.moves;
				this.size = p.size;
				this.emptyCol = p.emptyCol;
				this.emptyRow = p.emptyRow;
				this.board = new int[size][size];
				for (int row=0; row<size; row++)
				for (int col=0; col<size; col++)
					this.board[row][col] = p.board[row][col];
			}
			
			// return a new NinePuzzle which is the result of a random move
			// of this NinePuzzle
			public NinePuzzle moveRandomly() {
				NinePuzzle result = null;
				while (result == null) {
					Move move;
					switch ((int)(4*Math.random())) {
						case 0: move = Move.up; break;
						case 1: move = Move.down; break;
						case 2: move = Move.left; break;
						default: move = Move.right;
					}
					result = this.move(move);
				}
				return result;
			}

			// return a NinePuzzle which is the result of moving the empty space
			// in the given direction.  If this would place the empty space
			// off the board, return "null"
			public NinePuzzle move(Move move) {
				assert(move != null);
				int drow = 0, dcol = 0;
				switch (move) {
					case up:    drow = -1; break;
					case down:  drow = +1; break;
					case left:  dcol = -1; break;
					case right: dcol = +1; break;
				}
				int newEmptyRow = emptyRow + drow;
				int newEmptyCol = emptyCol + dcol;
				if ((newEmptyRow < 0) || (newEmptyRow >= size) ||
				    (newEmptyCol < 0) || (newEmptyCol >= size))
				    return null;
				NinePuzzle result = new NinePuzzle(this);
				result.emptyRow = newEmptyRow;
				result.emptyCol = newEmptyCol;
				int otherPiece = result.board[newEmptyRow][newEmptyCol];
				result.board[newEmptyRow][newEmptyCol] = EMPTY;
				result.board[emptyRow][emptyCol] = otherPiece;
				result.move = move;
				result.moves = this.moves + 1;
				return result;
			}

			public static NinePuzzle makeRandomPuzzle(int maxMovesToSolve) {
				NinePuzzle puzzle = new NinePuzzle();
				while (maxMovesToSolve-- > 0)
					puzzle = puzzle.moveRandomly();
				puzzle.moves = 0;
				puzzle.move = null;
				puzzle.previous = null;
				return puzzle;
			}
		

}
