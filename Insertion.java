import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Insertion{
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static int temp=0;
	public static int j;
	public static int comparisons;
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
		for(int i=1; i<arr.size(); i++){ //sorting portion (iterating through elements)
			j=i;
			comparisons++; //COMPARISON BELOW - accounts for first comparion
			while(j>0&&arr.get(j-1)>arr.get(j)){ //COMPARISON ||| this portion loops to move elements to correct position
				comparisons++; //accounts for next comparison which WILL happen
				swaps++; //SWAP BELOW
				swap(j, j-1); //SWAP
				j-=1;
			}
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
