// Updated for testing CI
import java.util.Scanner;

class Dec2Hex {
   public static int arg1;

   public static String convertToHex(int decimal) {
       char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
       String hexadecimal = "";
       int num = decimal;
       
       if (num == 0) {
           return "0";
       }
       
       while (num > 0) {
           int remainder = num % 16;
           hexadecimal = hexChars[remainder] + hexadecimal;
           num = num / 16;
       }
       
       return hexadecimal;
   }

   public static void main(String[] args) {
       try {
           // Check if argument is provided
           if (args.length == 0) {
               System.err.println("Error: No input value provided");
               System.err.println("Usage: java Dec2Hex <decimal_number>");
               System.exit(1);
           }

           // Try to parse the input argument
           try {
               arg1 = Integer.parseInt(args[0]);
               
               // Check for negative numbers
               if (arg1 < 0) {
                   System.err.println("Error: Please provide a positive decimal number");
                   System.exit(1);
               }
               
               System.out.println("Converting the Decimal Value " + arg1 + " to Hex...");
               String result = convertToHex(arg1);
               System.out.println("Hexadecimal representation is: " + result);
               
           } catch (NumberFormatException e) {
               System.err.println("Error: '" + args[0] + "' is not a valid decimal number");
               System.err.println("Usage: java Dec2Hex <decimal_number>");
               System.exit(1);
           }
           
       } catch (Exception e) {
           System.err.println("An unexpected error occurred: " + e.getMessage());
           System.exit(1);
       }
   }
}
