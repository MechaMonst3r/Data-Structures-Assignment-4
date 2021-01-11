
import java.util.Arrays;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrahman
 */


public class SortingTest {
    public static void swap(Comparable [] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void bubbleSort(Comparable[] a){
        boolean isSorted = true;
        for(int i=0; i<a.length; i++)
            for(int j=i+1; j<a.length; j++)
                if(a[i].compareTo(a[j]) > 0){
                    swap(a, i, j);
                    isSorted = false;
                }
                    
    }
    
    public static void mergeSort(Comparable [] a){
        // base case O(1)
        if(a.length == 1)
            return;
        
        // divide O(1)
        Comparable [] left = new Comparable[a.length/2];
        Comparable [] right = new Comparable[a.length - left.length];
        System.arraycopy(a, 0, left, 0, a.length/2);
        System.arraycopy(a, left.length, right, 0, right.length);
        
        // ??? 
        mergeSort(left);
        mergeSort(right);
        
        // O(n)
        merge(left, right, a);
        
    }
    
    public static void merge(Comparable left[], Comparable right[], Comparable result[]){
        int a=0;
        int b=0;
        int i=0;
        Comparable[] temp= new Comparable[left.length+right.length];
        while(a<left.length && b<right.length) {
            if (left[a].compareTo(right[b])<0) {
                temp[i] = left[a];
                a++;
            }
            else{
                temp[i] = right[b];
                b++;
            }
            i++;
            
        }
        if (a < left.length)
        {
            System.arraycopy(left, a, temp, i, left.length - a);
        }
        else 
        {
            System.arraycopy(right, b, temp, i, right.length - b);
        }
        
        System.arraycopy(temp, 0, result, 0, temp.length);
    }
    
    
    
    public static void quickSort(Comparable a[], int low, int high){
            if(a.length == 1)
                return;
            
            if(low >= high)
                return;
            
            Comparable pivot = a[high];
            int i = low;
            int j = high-1;
            while(i<=j){
                while(a[i].compareTo(pivot) < 0)
                    i++;
                
                while(a[j].compareTo(pivot) > 0)
                    j--;
                
                if(i<=j){
                    swap(a, i, j);
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
    
    
    
    
    
    public static void main(String[] args) {
        Integer arr[] = {4, 8, 2, -5, 10, 6, 10, 20, 3};
        String arrs[] = {"Abc", "test", "Hi", "Hello", "World"};
        quickSort(arr, 0, arr.length-1);
        quickSort(arr, 0, arr.length -1);
        //mergeSort(arrs);
        System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(arrs));
        
    }
    
}
