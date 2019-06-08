/*
  Author - Panashe J Katema
  Date Created - May 2018
  COM1005 - External Assignment
*/

public class EightPuzzleSearch extends Search {
  private int[][] target;

  // assigns given target as the target state
  public EightPuzzleSearch(int[][] t){
    target=t;
  }
  // returns target as a 3d array
  public int[][]getTarget(){
    return target;
  }
}
