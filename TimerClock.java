   // import java.util.Scannner;

public class TimerClock {
    private int hour;        // 0-23
    private int mins;        // 0-59       //instance level variables ()
    private int seconds;     // 0- 59

    // Constructor to initialize the time to 00:00:00
    public TimerClock() {
        hour = 0;
        mins = 0;
        seconds = 0;
    }

    // Method to set the time with validation
    public void setTime(int h, int m, int s) {
        if (h < 0 || h >= 24 || s < 0 || s >= 60 || m < 0 || m >= 60) {
            throw new IllegalArgumentException("Invalid Time");
        }
        this.hour = h;
        this.mins = m;
        this.seconds = s;
    }

    // Method to return the time in universal format (HH:MM:SS)
    public String toUniversalString () {
        return String.format("%02d:%02d:%02d", hour, mins, seconds);
    }
    
    public static void main(String[] args) {
       // Scanner Userinput= new Scanner(System.in);
     
       TimerClock obj = new TimerClock();
        displayTime("After object is created: ", obj);

    //     int hr =Userinput.nextInt();
    //     int m = Userinput.nextInt();
    //     int sec= Userinput.nextInt();

        try {
            obj.setTime(11, 04, 56);             //obj.setTime(hr,m,sec);
            displayTime("After clock is set: ", obj);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Helper method to display the time
    public static void displayTime(String s, TimerClock t1) {
        System.out.println(s + t1.toUniversalString());
    
        //Userinput.close
    }
}