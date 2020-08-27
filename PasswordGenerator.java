import java.util.Scanner;

public class PasswordGenerator {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean splChar = false; 
    boolean numChar = false;
    
    System.out.println("----------------------------------------------------");
    System.out.println("Welcome to the Password Generator! ");
    System.out.println("Enter the length of your desired password to begin: ");
    int len = sc.nextInt();

    String userIn = "";
    System.out.println();
    System.out.println("Choose a password type from the given options below: ");
    System.out.println("1. One Time Password: 'o'");
    System.out.println("2. Random Generated Password: 'r'");
    System.out.println("----------------------------------------------------");

    userIn = sc.next();
    if (userIn.equals("o") || userIn.equals("O")) { // ignoring case
      OTP(len);
    }
    
    if (userIn.equals("r") || userIn.equals("R")) {
      System.out.println("Do you want to enable special characters (Y/N)? ");
      userIn = sc.next();
      if (userIn.equals("y") || userIn.equals("Y")) {
        splChar = true;
      }
      System.out.println("Do you want to enable numerical characters (Y/N)? ");
      userIn = sc.next();
      if (userIn.equals("y") || userIn.equals("Y")) {
        numChar = true;
      }
      randomPassword(len, splChar, numChar);
    }
  }
  
  private static void OTP(int len) {
    
  }
  
  private static void randomPassword(int len, boolean splChar, boolean numChar) {
    
  }

}
