public class quiz{
    //bubble sort method
    public static void bubbleSort(int[] nums){
        //for the length of the array
        for(int i = 0; i < nums.length; i++){
            //for the length of the array - 1
            for(int j = 0; j < nums.length - 1; j++){
                //if the current element is greater than the next element
                if(nums[j] > nums[j + 1]){
                    //swap the elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        //e
        int nums[] = {8, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.print("[");
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1){
                System.out.print(nums[i]);
            }
            else{
                System.out.print(nums[i] + ", ");
            }
        }
        System.out.println("]");
        System.out.println("Sorted Array");
        bubbleSort(nums);
        System.out.print("[");
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1){
                System.out.print(nums[i]);
            }
            else{
                System.out.print(nums[i] + ", ");
            }
        }
        System.out.println("]");

        
    }
}
/*
Write a Java program to sort an array of given integers using the Bubble sorting Algorithm. Use the following sample data, which you may hard code into your program. 

    int nums[] = {8, -5, 3, 2, 1, 0, 45};

Your Sample Output should write out the Original Array contents and then the Sorted Array contents in this format.

Sample Output:  Make sure your output has the [ ] brackets

Original Array:
[8, -5, 3, 2, 1, 0, 45]
Sorted Array
[-5, 0, 1, 2, 3, 8, 45]
 */