import java.util.Scanner;
class Main {
  
  public static String[][] rotate(String[][] original){
    int N = original.length, M = original[0].length;
    String[][] new_array = new String[M][N];
    
    for (int i = 0; i < M; i++){
      for (int j = 0; j < N; j++){
    	  System.out.println(j + " " + (M - 1 - i));
        new_array[i][j] = original[N - j - 1][i];
      } 
    }
 
    return new_array;
  }
  
  public static void main(String[] args) {
    
    
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), M = sc.nextInt();
    String[][] array = new String[N][M];
 
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        array[i][j] = sc.next();
      }
    }
      String[][] result = rotate(array); 
    for (int i = 0; i < result.length; i++){
      for (int j = 0; j < result[0].length; j++){
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }

    }
} 
