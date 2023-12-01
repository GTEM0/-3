package ch11.hashset;
import java.util.*; 

class HashSet_Bingo { 
      public static void main(String[] args) { 
            Set set = new HashSet(); 
        
//          Set set = new LinkedHashSet(); 
            int[][] board = new int[5][5]; 

            //중복된 값을 담고 싶지 않을 때  set을 사용하면 됨
            
            for(int i=0; set.size() < 25; i++) { 
                  set.add((int)(Math.random()*50)+1+""); 
            } 

            System.out.println("set 집합에 대한 반복자가 생성되며, 이 반복자는 요소를 순회하는 데 사용");
            Iterator it = set.iterator(); 
           // 

            for(int i=0; i < board.length; i++) { 
                  for(int j=0; j < board[i].length; j++) { 
                        board[i][j] = Integer.parseInt((String)it.next());
                        System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]); 
                  } 
                  System.out.println(); 
            } 
            
            
            
            System.out.println("향상된 for문 사용가능함");
            for( Object num : set){
            	System.out.println( num);
            }
            //
            
      } // main
} 
