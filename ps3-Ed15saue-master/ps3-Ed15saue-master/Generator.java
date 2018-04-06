import java.util.*;
/**
 * Write a description of class Generator here.
 * 
 * Eric Sauer, Sara Lopez, Emily DeLorenzo
 * @version (a version number or a date)
 */
public class Generator
{
    public static int temp;
    //public static int i;
    public static int bNumComparisons;
    public static int sNumComparisons;
    public static int iNumComparisons;
    public static int[] random(int range, int size){
        Random r = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = r.nextInt(range);
        }
        return randomArray;
    }

    public static int[] ascending(int range, int size){
        Random r = new Random();
        int[] ascending = new int[size];
        temp = r.nextInt(range);
        for (int i = 0; i < ascending.length; i++){
            if(i == 0) {
                ascending[0] = temp;
            }
            else {
                temp = temp + 1;
                ascending[i] = temp;
            }
        }
        return ascending;
    }

    public static int[] descending(int range, int size){
        Random r = new Random();
        int[] descending = new int[size];
        temp = r.nextInt(range);
        for (int i = 0; i < descending.length; i++) {
            if(i == 0) {
                descending[0] = temp;
            }
            else {
                temp = temp - 1;
                descending[i] = temp;
            }
        }
        return descending;
    }
    
    public static int[] nearlySorted(int range, int size){
        Random r = new Random();
        int[] nearlySorted = new int[size];
        temp = r.nextInt(range);
        for (int i = 0; i < nearlySorted.length; i++) {
            if(i == 0) {
                nearlySorted[0] = temp;
            }
            else {
                temp = temp + 1;
                nearlySorted[i] = temp;
            }
        }
        double tenPercent = Math.round(size*0.1);
        int i = 0;
        while ( i < tenPercent) {
            int tempVal1 = r.nextInt(size);
            int tempVal2 = r.nextInt(size);
            while (tempVal1 == tempVal2) {
                tempVal2 = r.nextInt(size);
            }
            int swap1, swap2 = 0;
            swap1 = nearlySorted[tempVal1];
            swap2 = nearlySorted[tempVal2];
            nearlySorted[tempVal2] = swap1;
            nearlySorted[tempVal1] = swap2;
            i++;
        }
        return nearlySorted;
    }

    public static int[] selectionSort(int[] a) {
        temp = 0;
        sNumComparisons = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                sNumComparisons++;
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }

    public static int[] insertionSort(int[] a) {
        temp = 0;
        iNumComparisons = 0;
        for (int i = 1; i <= a.length - 1; i++) {
            temp = a[i];
            int min = i - 1;
            while (min >= 0 && a[min] > temp) {
                a[min+1] = a[min];
                min = min - 1;
                iNumComparisons++;
            }
            a[min+1] = temp;
        }
        return a;
    }
    
    public static int[] bubbleSort(int[] a) {
        temp = 0;
        bNumComparisons = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j-1] > a[j]) {
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
                bNumComparisons++;
            }
        }
        return a;   
    }
    
    /**
     *Enter a sorting algorithm (SelectionSort, InsertionSort, or BubbleSort), a range of values, 
     *the array size, and the number of trials
     */
    public static void main(String[] args) {
        Generator G = new Generator();
        String choice = args[0];
        int range = Integer.parseInt(args[1]) + 1;
        int size = Integer.parseInt(args[2]);
        int numTrials = Integer.parseInt(args[3]);
        double start = 0.0;
        double end = 0.0;
        double current = 0.0;
        double best = 1048576.0;
        if (choice == "SelectionSort") {
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = random(range, size);
                start = System.currentTimeMillis();
                selectionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Selection sort with a random array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + sNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = ascending(range, size);
                start = System.currentTimeMillis();
                selectionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Selection sort with a random ascending array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + sNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = descending(range, size);
                start = System.currentTimeMillis();
                selectionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Selection sort with a random descending array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + sNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = nearlySorted(range, size);
                start = System.currentTimeMillis();
                selectionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Selection sort with a nearly sorted array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + sNumComparisons);
            System.out.println();
        }
        
        if (choice == "InsertionSort") {
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = random(range, size);
                start = System.currentTimeMillis();
                insertionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Insertion sort with a random array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + iNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = ascending(range, size);
                start = System.currentTimeMillis();
                insertionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Insertion sort with a random ascending array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + iNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = descending(range, size);
                start = System.currentTimeMillis();
                insertionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Insertion sort with a random descending array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + iNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = nearlySorted(range, size);
                start = System.currentTimeMillis();
                insertionSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Insertion sort with a nearly sorted array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + iNumComparisons);
            System.out.println();
        }
        
        if (choice == "BubbleSort") {
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = random(range, size);
                start = System.currentTimeMillis();
                bubbleSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Bubble sort with a random array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + bNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = ascending(range, size);
                start = System.currentTimeMillis();
                bubbleSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Bubble sort with a random ascending array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + bNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = descending(range, size);
                start = System.currentTimeMillis();
                bubbleSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Bubble sort with a random descending array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + bNumComparisons);
            System.out.println();
            start = 0.0;
            end = 0.0;
            current = 0.0;
            best = 1048576.0;
            for (int i = 0; i < numTrials; i++) {
                int[] randomArray = nearlySorted(range, size);
                start = System.currentTimeMillis();
                bubbleSort(randomArray.clone());
                end = System.currentTimeMillis();  
                current = end - start;
                if (current < best) {
                    best = current;
                }
            }
            System.out.println("Bubble sort with a nearly sorted array of size: " + size);
            System.out.println("The best time out of " + numTrials + " trials: " + best/1000 + " seconds.");
            System.out.println("Number of comparisons: " + bNumComparisons);
            System.out.println();
        }
    }
}

