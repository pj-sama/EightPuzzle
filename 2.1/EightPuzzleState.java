/*
  Author - Panashe J Katema
  Date Created - May 2018
  COM1005 - External Assignment
*/
import java.util.*;

public class EightPuzzleState extends SearchState {

  //The puzzle grid as an array
  private int[][] current; // value in each position eg [0][0] is top left corner
  private int estRemCost;
  //constructor - takes the array as input!
  public EightPuzzleState(int[][] puzzle){
    current = puzzle;

  }
  //goalP
  public boolean goalP(Search searcher){ // Function to check if Current state matches the goal state!
    // Set a variable "matching" to true
    boolean matching = true;
    // Get target state?
    EightPuzzleSearch eightSearch = (EightPuzzleSearch) searcher;
    int[][] targetState=eightSearch.getTarget();
    for (int i=0;i<=2;i++){
      for (int j=0;j<=2;j++){
        //Compare target[i][j] to Current[i][j] - If not equal, then fails - set variable "matching" to false
        if (targetState[i][j]!=current[i][j]){
          matching = false;
        }
      }
    }
    return matching;
  }
  // Will get successor states by moving the 0, it cant move out of bounds in the matrix though. Like at [0][1] wont move up, can move down, left and right
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    EightPuzzleSearch eightSearch = (EightPuzzleSearch) searcher;
    ArrayList succList=new ArrayList();
    int spaceI=0;
    int spaceJ=0;
    // Find the zero
    for (int i=0;i<=2;i++){
     for (int j=0;j<=2;j++){
     	if (current[i][j]==0) {
     		spaceI=i;
     		spaceJ=j;
     	}
     }
    }
    // ----------- Moves!!!------------
    // move zero up
    if (spaceI !=0) {
    	int[][] nu=getCopy(current);
    	nu[spaceI][spaceJ]=nu[spaceI-1][spaceJ];
    	nu[spaceI-1][spaceJ]=0;
    	EightPuzzleState su=new EightPuzzleState(nu);
    	succList.add(su);
    }
    // move zero down
    if (spaceI!=2) {
    	int[][] nd=(int[][])getCopy(current);
    	nd[spaceI][spaceJ]=nd[spaceI+1][spaceJ];
    	nd[spaceI+1][spaceJ]=0;
    	EightPuzzleState sd=new EightPuzzleState(nd);
    	succList.add(sd);
    }
    // move zero left
    if (spaceJ!=0) {
    	int[][] nl=(int[][])getCopy(current);
    	nl[spaceI][spaceJ]=nl[spaceI][spaceJ-1];
    	nl[spaceI][spaceJ-1]=0;
    	EightPuzzleState sl=new EightPuzzleState(nl);
    	succList.add(sl);
    }
    // move zero right
    if (spaceJ!=2) {
    	int[][] nr=(int[][])getCopy(current);
    	nr[spaceI][spaceJ]=nr[spaceI][spaceJ+1];
    	nr[spaceI][spaceJ+1]=0;
    	EightPuzzleState sr=new EightPuzzleState(nr);
    	succList.add(sr);
    }
    return succList;
  }

  // Make a copy of the current puzzle
  private int[][] getCopy(int[][] original) {
    int[][] copyPuzzle = {{0,0,0},{0,0,0},{0,0,0}};
    for (int i=0;i<=2;i++){
      for (int j=0;j<=2;j++) {
        copyPuzzle[i][j]=original[i][j];
      }
    }
    return copyPuzzle;
  }
  public int[][] getCurrent() {
    return current;
  }
  // if the two states being checked are the same, will return true, if different will return false.
  public boolean sameState(SearchState statePuz) {
    boolean matching = true;
    EightPuzzleState statePuz1 = (EightPuzzleState) statePuz;
    int[][] testState = statePuz1.getCurrent();
    for (int i=0;i<=2;i++){
      for (int j=0;j<=2;j++){
        if (testState[i][j]!=current[i][j]){
          matching = false;
        }
      }
    }
    return matching;
  }
// Nice cool looking prints
  public String toString(){
    return("Puzzle state: \n"+ current[0][0] + " "+ current[0][1] + " "+ current[0][2]+ "\n"+ current[1][0] + " "+ current[1][1] + " "+ current[1][2] + "\n"+ current[2][0] + " "+ current[2][1] + " " + current[2][2] + " "  );
  }
}
