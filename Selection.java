import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Selection{
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static int temp=0;
	public static int comparisons; //only comparisons of array elements will count - not iterator variables in, say, a for loop
	public static int swaps; //I AM ASSUMING one "move" == one "swap" - this is consistent across my programs so it shouldnt matter
	public static void main(String[] args){
		try{
			File file1 = new File("sample_data.csv"); 
			Scanner reader = new Scanner(file1);
			while(reader.hasNextLine()){
				int data = Integer.parseInt(reader.nextLine()); //adding the data to a list
				arr.add(data);
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
		for(int i=0; i<arr.size(); i++){ //sorting portion (iterating through elements)
            //finding next smallest elements at beginning of each iterasion
            int smallest=-1;
            int smallestIndex=-1;
            for(int j=i; j<arr.size(); j++){ //second loop finds smallest remaining element
                comparisons++; //comparison BELOW
                if(arr.get(j)<smallest||smallest==-1){
                    smallest = arr.get(j);
                    smallestIndex=j;
                }
            }
            //swapping current iteration index with next smallest
            swaps++; //SWAP BELOW
            swap(i, smallestIndex);
		}
		for(int thing:arr) System.out.println(thing); //printing out results VVV x2
		System.out.println(comparisons + " COMPARISONS");
		System.out.println(swaps + " SWAPS");
	}
	public static void swap(int indA, int indB){ //swap helper function, does what it says
	temp = arr.get(indA);
	arr.set(indA, arr.get(indB));
	arr.set(indB, temp);
	}
}
