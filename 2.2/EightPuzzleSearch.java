/*
  Author - Panashe J Katema
  Date Created - May 2018
  COM1005 - External Assignment
*/

public class EightPuzzleSearch extends Search {
  private int[][] target;

  public EightPuzzleSearch(int[][] t){
    target=t;
  }
  public int[][]getTarget(){
    return target;
  }
}
