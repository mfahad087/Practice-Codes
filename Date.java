import java.util.Scanner;
public class Date {
    private int day;
    private int month ;
    private int year ;
    
    public Date(){
        this.day=1;
        this.month=1;
        this.year=2000;
    }
    public Date (int day, int month, int year) {
    if ((day>31 || day<1 ) || (month <1 || month >12)
        ||(year<0))
        throw new 
        IllegalArgumentException("INVALID DATE");
    this.day=day;
    this.month=month;
    this.year=year;
    }
    
    // to return date
    public String ToDate(){
        return String.format("%02d|%02d|%02d",day,month,year);
    }
    public static void main(String [] args ){
        Scanner dateuser= new Scanner(System.in);
        System.out.println("Enter Day:");
        int day=dateuser.nextInt();
        System.out.println("Enter Month:");
        int month=dateuser.nextInt();
        System.out.println("Enter Year:");
        int year=dateuser.nextInt();
        Date userdate =new Date(day,month,year);
        System.out.println("Entered Date is :"+ userdate.ToDate());
        dateuser.close();
    }
}