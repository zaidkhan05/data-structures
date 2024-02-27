public class Assignment6part2_2 {
    public static void main(String[] args) {
        //time complexity is O(n)
        //why
        //the for loop is O(n)
        //so the time complexity is O(n)
        for(int i = 0; i < 10; i++){
            System.out.println(i * 10 + " miles is " + (i * 10 * 1.6) + " kilometers");
        }
        System.out.println("Time complexity is O(n) because the time it takes to convert distance measurements from miles to kilometers for input of n numbers is linear");
        
    }
}

/*
2.	Write a java program that will convert distance measurements from miles to kilometers for input of n numbers, and determine the worst case efficiency.

Specifically, the program needs to convert 0, 10, 20, 30, 40 , 50, 60, 70, 80, and 90 miles to kilometers displaying both the number of miles and the number of kilometers on the same line. Tip: 1 mile = 1.6 x km

 */