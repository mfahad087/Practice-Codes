import java.util.Scanner;

class Animal {
   String name ;
   int age ;
   String type; 
     
    public Animal ( String name , int age , String type ){
    this.name=name;
    this.age= age;
    this.type= type ;
   }

   public void display (){
    System.out.println(" Name:"+ name);
    System.out.println(" Age :"+ age);
    System.out.println(" Type :"+ type);
   }
   
   public void display2 (){
    System.out.println("Entered Name:"+ name);
    System.out.println("Entered Age :"+ age);
    System.out.println("Entered Type :"+ type);
   }

   public static void main (String [] args ){
    Animal animal1 = new Animal( " Lion" ,12 ," Wild");
    animal1.display();


    Animal animal2=new Animal("", 3 , "");
    animal2.name = " Dog";
    animal2.age = 15;
    animal2.type= "Pet";

    Animal animal3 = new Animal("Fish",12, "Aquatic");
    animal3.display();


// FOR USER INPUT 
Scanner useranimal = new Scanner(System.in);
System.out.println("Details From USER:");
System.out.println("Enter Name Of Your Animal:");
String name1=useranimal.nextLine();
System.out.println("Enter Age Of Animal:");
int age1=useranimal.nextInt();
useranimal.nextLine();
System.out.println("Enter Type Of Animal:");
String type1=useranimal.nextLine();
Animal userAnimal = new Animal( name1 , age1, type1);
userAnimal.display2();
useranimal.close();

 }
}
