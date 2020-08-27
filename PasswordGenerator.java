import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    static Random rand = new Random();
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean splChar = false; 
    boolean numChar = false;
    boolean upperCaseChar = false;
    
    System.out.println("----------------------------------------------------");
    System.out.println("Welcome to the Password Generator! ");
    System.out.println("Enter the length of your desired password to begin: ");
    int len = sc.nextInt();

    String userIn = "";
    System.out.println("----------------------------------------------------");
    System.out.println("Choose a password type from the given options below: ");
    System.out.println("1. One Time Password: 'o'");
    System.out.println("2. Random Generated Password: 'r'");
    System.out.println("----------------------------------------------------");

    userIn = sc.next();
    if (userIn.equals("o") || userIn.equals("O")) { // ignoring case
      OTP(len);
    }
    
    if (userIn.equals("r") || userIn.equals("R")) {
      System.out.println("Do you want to include special characters (Y/N)? ");
      userIn = sc.next();
      if (userIn.equals("y") || userIn.equals("Y")) {
        splChar = true;
      }
      System.out.println("Do you want to include numerical characters (Y/N)? ");
      userIn = sc.next();
      if (userIn.equals("y") || userIn.equals("Y")) {
        numChar = true;
      }
      System.out.println("Do you want to include upper case characters (Y/N)? ");
      userIn = sc.next();
      if (userIn.equals("y") || userIn.equals("Y")) {
        upperCaseChar = true;
      }
      randomPassword(len, splChar, numChar, upperCaseChar);
    }
  }
  
  private static void OTP(int len) {
    int passDig = 0;
    String password = "";
    for(int i = 0; i < len; i++) {
      passDig = rand.nextInt(10); // Random number from 1 - 10
      password += passDig;
    }
    System.out.println("Your OTP of length " + len + " is: " + password);
  }
  
  private static void randomPassword(int len, boolean splChar, boolean numChar, boolean upperChar){
    
    
  }

}
