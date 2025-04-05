public class arrayavg{
  public static void main(String[] args) {
      double[] values = {12.90, 88.90, 76.90, 55.55, 99.00, 92.12};
      double sum = 0;
      for (int i = 0; i < values.length; i++){
          sum += values[i];
      }

      System.out.println("The Sum Of All Elements In ARRAY is: " + sum);
      System.out.println("The Average Of All Elements In ARRAY is: " + sum / values.length);
  }
}

