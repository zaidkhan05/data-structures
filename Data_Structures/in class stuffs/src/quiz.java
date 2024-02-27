public class quiz{
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < n; i++)	{
            for (int j = 0; j < i * i; j++) {
                for (int k = 0; k < j; k++) {
                sum++;
                }
            }
        }
        //time complexity is O(n^5)
        //why
        //the first for loop is O(n)
        //the second for loop is O(n^2)
        //the third for loop is O(n^2)
        //the sum++ is O(n^2)
        //so the time complexity is O(n^5)
        //
            
        

        
    }
}
