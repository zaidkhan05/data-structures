import java.util.Scanner;
import java.io.*;

public class Lab10 {


    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        //e
        System.out.println("Enter the first file name(the full path): ");
        String file1 = sc.nextLine();
        System.out.println("Enter the second file name(the full path): ");
        String file2 = sc.nextLine();
        //open both files
        File fileOne = new File(file1);
        File fileTwo = new File(file2);
        //compare the lines
        try {
            Scanner input1 = new Scanner(fileOne);
            Scanner input2 = new Scanner(fileTwo);
            int lineNum = 1;
            while (input1.hasNextLine() && input2.hasNextLine()) {
                String line1 = input1.nextLine();
                String line2 = input2.nextLine();
                if (!line1.equals(line2)) {
                    System.out.println("Line " + lineNum);
                    System.out.println("< " + line1);
                    System.out.println("> " + line2);
                }
                lineNum++;
            }
            if (input1.hasNextLine() || input2.hasNextLine()) {
                System.out.println("Files have different number of lines");
            }
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}