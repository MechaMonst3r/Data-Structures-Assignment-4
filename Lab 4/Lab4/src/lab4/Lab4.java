package lab4;


import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;


public class Lab4 {
    
    //Swaps 2 elements in an array
    public static void swap(Comparable [] a, int i, int j)
     {
        Comparable temp = a[i]; //Stores an element in a temp variable
        a[i] = a[j];//Sets the variable to the one it has to switch with
        a[j] = temp;//Sets the old variable to the one stored in temp
     }
    
    /*Function to sort array using insertion sort*/
    public static void insertionSort(int arr[]) 
     { 
        int n = arr.length; //n is the length of the array
        for (int i = 1; i < n; ++i) { //i starts at index 1
            int key = arr[i]; //Key is the element in index 1
            int j = i - 1; //J is set to index 0
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { //When j is greater or equal to 0 AND the element in index j is greater then the key
                arr[j + 1] = arr[j];  //Sets the next idndex as the previous one                               
                j = j - 1; //Sets J to the index prior
            } 
            arr[j + 1] = key; //Puts the key in the proper place
        } 
     } 

    public static void bubbleSort(Comparable[] a){
        boolean isSorted = true;
        for(int i=0; i<a.length; i++)
            for(int j=i+1; j<a.length; j++)
                if(a[i].compareTo(a[j]) > 0){ //Swaps 2 elements if N is greater then N + 1
                    swap(a, i, j);
                    isSorted = false;
                }
                    
    }
    
    public static void mergeSort(Comparable [] a){
        // base case O(1)
        if(a.length == 1)
            return;
        
        // divide O(1)
        Comparable [] left = new Comparable[a.length/2]; //Creates a new array thats half the size of the orignal
        Comparable [] right = new Comparable[a.length - left.length]; // Creates an array that represents the right side of the array
        System.arraycopy(a, 0, left, 0, a.length/2); //Copies the left side of the orignal array to the left array
        System.arraycopy(a, left.length, right, 0, right.length); //Copies the right side of the array to the Right Array
        
        // ??? 
        mergeSort(left);//Calls the current method again except on the Left Array
        mergeSort(right);//Calls the same method again on the Right Array
        
        // O(n)
        merge(left, right, a);//Merges the left and right array and stores it back into the original array
        
    }
    
    //Merges the passed left and right arrays, then stores it into the result array
    public static void merge(Comparable left[], Comparable right[], Comparable result[]){
        int a=0;//Counter for left array
        int b=0;//Counter for right array
        int i=0;//Index counter
        Comparable[] temp= new Comparable[left.length+right.length];//Temp array to store the merged results
        while(a<left.length && b<right.length)
          {
            if(left[a].compareTo(right[b])<0)//While the elements in the left array are less then the ones in the right
             {
                temp[i] = left[a];//Copies the elements in the left array to the temp array
                a++;//Increases left counter
             }
            
            else
             {
                temp[i] = right[b];//Copies the right array to the temp array
                b++;//Increases the right counter
             }
            i++;//Increases the temp index
            
          }
        if (a < left.length)
        {
            System.arraycopy(left, a, temp, i, left.length - a);
        }
        else 
        {
            System.arraycopy(right, b, temp, i, right.length - b);
        }
        
        System.arraycopy(temp, 0, result, 0, temp.length);//Copies to the temp array to the passed result
    }
    
    
    
    public static void quickSort(Comparable a[], int low, int high)
     {
            if(a.length == 1)
                return;
            
            if(low >= high)
                return;
            
            Comparable pivot = a[high]; //Sets the pivot for the max range you want to sort
            int i = low;//Sets an index to the lowest search range
            int j = high-1;//Sets an index to the second highest search range
            
            while(i<=j)//Runs the loop until i and j are the same
             {
                while(a[i].compareTo(pivot) < 0)
                    i++;//Increases the index variable while the element is less then the pivot point
                
                while(a[j].compareTo(pivot) > 0)
                    j--;//decreases the j variable if the element in the current index is less then the pivot
                
                if(i<=j)
                 {
                    swap(a, i, j);//Swaps the two elements into their correct places
                    i++;
                    j--;
                 }
             }
            swap(a, i, high);
            //if(low < j)
                quickSort(a, low, i-1);
            
            //if(high > i)
                quickSort(a, i+1, high);    
     }
    
    public static void selectionSort(int[] arr)
     {  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for(int j = i + 1; j < arr.length; j++)
             {  
                if (arr[j] < arr[index])
                 {  
                    index = j;//searching for lowest index  
                 }  
             }  
            
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
     }  
    
    
    
    
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input;
        input = scan.nextInt();
        
        Integer[] arr = new Integer[input];
        
        for(int i = 0; i < arr.length; i++)
          { 
           int num = (int)(Math.random()*500) + 1;
           
           arr[i] = num; 
          }
        
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis(); 
      
        quickSort(arr, 0, arr.length - 1);
        
        endTime = System.currentTimeMillis(); 
        executionTime = endTime - startTime;
        
        System.out.println(executionTime);
    }
    
}
