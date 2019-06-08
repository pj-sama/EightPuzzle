/*
  Author - Panashe J Katema
  Date Created - May 2018
  COM1005 - External Assignment
*/
import sheffield.*;

public class RunEightPuzzle {
  public static void main(String[] args){
    EasyWriter sc = new EasyWriter();
    int[][] target = {{1,2,3},{4,5,6},{7,8,0}};
    int[][] p1 = {{1,0,3},{4,2,6},{7,5,8}};
    int[][] p2 = {{4,1,3},{7,2,5},{0,8,6}};
    int[][] p3 = {{2,3,6},{1,5,8},{4,7,0}};
    EightPuzzleSearch esearch = new EightPuzzleSearch(target);
    SearchState initialState = (SearchState) new EightPuzzleState(p3);

    String resd = esearch.runSearch(initialState, "breadthFirst");
    sc.println(resd);
  }
}
