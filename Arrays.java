public class Arrays {
    public static void main(String[] args) {
        int[] marks = {12, 13, 14, 15, 16, 17, 18};  // created array of 7 elements
        
        int[] newMarks = new int[7]; 

        System.out.println("Total Elements In Array:" + newMarks.length); 

        for(int i =0 ; i <= 7 ; i++){
            System.out.println(marks[i]);
        }
        
           //   for (int i = 0; i < marks.length; i++)
          //    { newMarks[i] = marks[i];}
        
    }   
}
