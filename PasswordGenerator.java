import java.util.Scanner;
import java.util.Random;


public class PasswordGenerator {
  static Random rand = new Random();

  /**
   * Main method that invokes the menu, records the inclusion of certain characters and calls all
   * sub methods.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean splChar = false;
    boolean numChar = false;
    boolean upperCaseChar = false;

    print1();
    int len = sc.nextInt();
    
    print2();
    int numPwd = sc.nextInt();
    
    for(int i = 0; i < numPwd; i++) {
    String userIn = "";
    print3();

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
  }
  
  /**
   * Prints the first part of the menu.
   * 
   */
  private static void print1() {
    System.out.println("----------------------------------------------------");
    System.out.println("Welcome to the Password Generator! ");
    System.out.println("Enter the length of your desired password to begin: ");  
   
  }
  
  private static void print2() {
    System.out.println("----------------------------------------------------");
    System.out.println("Enter the number of passwords you want to generate: ");  
    System.out.println("----------------------------------------------------");
   
  }
  
  /**
   * Prints the second part of the menu.
   * 
   */
  private static void print3() {   
    System.out.println("----------------------------------------------------");
    System.out.println("Choose a password type from the given options below: ");
    System.out.println("1. One Time Password: 'o'");
    System.out.println("2. Random Generated Password: 'r'");
    System.out.println("----------------------------------------------------");    
  }
  /**
   * Method that generates a numerical One Time Password of the desired length.
   * 
   * @param len - desired length of password
   */
  private static void OTP(int len) {
    int passDig = 0;
    String password = "";
    for (int i = 0; i < len; i++) {
      passDig = rand.nextInt(10); // Random number from 1 - 10
      password += passDig;
    }
    System.out.println("Your OTP of length " + len + " is: " + password);
  }
  
  /**
   * Method which generates the random password. All character sets are stored as continuous strings
   * Each string has a random number associated with it because the different character sets have
   * different lengths. An if statement checks after each addition whether the desired length is 
   * achieved and breaks out of the while loop when necessary.
   * 
   * @param len - desired length of password
   * @param splChar - indicates whether special characters are allowed
   * @param numChar - indicates whether numerical characters are allowed
   * @param upperChar - indicates whether upper case characters are allowed
   */
  private static void randomPassword(int len, boolean splChar, boolean numChar, boolean upperChar) {
    String splChars = "~!@#$%^&*()_:;',<.>?/|+={}[]`"; // 29
    String numChars = "1234567890"; // 10
    String upCase = "QWERTYUIOPASDFGHJKLZXCVBNM"; // 26
    String lowCase = "qwertyuiopasdfghjklzxcvbnm";// 26
    String password = "";

    // Assigning a different random number for each type of character

    int randSpl = 0;
    int randNum = 0;
    int randLet = 0;

    while (password.length() < len) {
      if (splChar) {
        randSpl = rand.nextInt(29); // 0 - 28
        password += splChars.charAt(randSpl);
        if (password.length() >= len) {
          break;
        }
      }
      if (numChar) {
        randNum = rand.nextInt(10);
        password += numChars.charAt(randNum);
        if (password.length() >= len) {
          break;
        }
      }
      
      randLet = rand.nextInt(26);

      if (upperChar) {
        password += upCase.charAt(randLet);
        if (password.length() >= len) {
          break;
        }
      }
      password += lowCase.charAt(randLet);
      if (password.length() >= len) {
        break;
      }
    }
    System.out.println("Your password of length " + len + " is: " + password);
  }

}
