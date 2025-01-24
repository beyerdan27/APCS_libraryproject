import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class CrossWalk{
	public static void main(String args[]){
		List<Integer> file1data;
		file1data = new ArrayList<Integer>();
		List<Integer> file2data;
		file2data = new ArrayList<Integer>();
		List<String> temp = new ArrayList<String>();
		try{
			File file1 = new File("StudentBarcodeIDS.csv");
			Scanner reader = new Scanner(file1);
			while(reader.hasNextLine()){
                int data = Integer.parseInt(reader.nextLine());
				file1data.add(data);
			}
			//file1data.remove(0);
			reader.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			e.printStackTrace();
		}
		try{
			File file2 = new File("libdata.csv");
			Scanner reader2 = new Scanner(file2);
			while(reader2.hasNextLine()){
				temp.add(reader2.nextLine());
                //int data = (int) reader2.nextDouble();
				//file2data.add(data);
			}
			//file2data.remove(0);
			reader2.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			e.printStackTrace();
		}
	/*for(int dataone:file1data){
		System.out.println(dataone);
	}
	*/
	
	for(String s:temp){
		System.out.println(s);
	}
	for(int datatwo:file2data){
		System.out.println(datatwo);
	}
	List<Integer> matches;
	matches = new ArrayList<Integer>();
	for(int a:file1data){
		for(int b:file2data){
			if(a==b) matches.add(a);
		}
	}
	System.out.println(matches.size() + " matches found.");
	for(int match:matches){
		System.out.println(match);
	}
	
	/*List<String> list;
	list = new ArrayList<String>();
	list.add("u8");
	list.add(0, "-2");
	list.add("2f");
	list.add(1, "a3");
	list.set(0, "sam");
	System.out.println(list.set(1, "ben"));
	*/
}
}
	
