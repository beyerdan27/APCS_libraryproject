import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
public class BinarySearchTest {
    static int target = 81;
    static int tempCutoffIndex;
    static int tempCutoffVal;
    static int indicesRemaining;
    static int indicesRemovedToTheLeft;
    static boolean found=false;
    public static void main(String[] args){
        ArrayList<Integer> datalist = new ArrayList<Integer>();
        try{
            File file1 = new File("testdata.txt"); //replace this with another list as needed
            Scanner reader = new Scanner(file1);
            while(reader.hasNextLine()){
                int data = Integer.parseInt(reader.nextLine()); //adding the data to a list
                datalist.add(data);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            //e.printStackTrace();
        }
        if(!isSorted(datalist)) {
            System.out.println("\n\nBinary search does not work on lists that are not sorted. Thus, the provided list will be automatically sorted");
            Collections.sort(datalist);
        }

while(true){
    if(getUserTarget()) break;
}



        while(datalist.size()>1){ //bin search loop
            tempCutoffIndex = datalist.size()/2;
            tempCutoffVal = datalist.get(tempCutoffIndex);
            /*if(tempCutoffVal==target){
                find(indicesRemovedToTheLeft);
                found=true;
                break;
            }  //seeing if by chance we land on the target, to make some rare cases more efficient*/ /*nevermind it broke a bunch of things so no */
            if(tempCutoffVal>target){ //case where we chop off the right half
                indicesRemaining = datalist.size()-tempCutoffIndex;
                for(int i=0; i<indicesRemaining; i++){
                    datalist.remove(tempCutoffIndex); //the index stays the same bc the right half of the list shifts left after removal
                }
            }
            if(tempCutoffVal<=target){ //specification not required (could make this an (if)-(else if)-(else) sturcture) but temporary for ease of coding
                indicesRemaining = tempCutoffIndex;
                for(int i=0; i<indicesRemaining; i++){
                    datalist.remove(0); //index same for same reason as above
                    indicesRemovedToTheLeft++;
                }
            }
        }
        if(datalist.get(0)!=target){
            System.out.println("\n\nTarget value not found in list provided.\n");
            return;
        }
        if(!found) find(indicesRemovedToTheLeft);
//0 1 2
    }
    public static void find(int index){
        System.out.println("\n\nThe target value " + target + " was found at Index " + index + "\n");
    }
    public static boolean isSorted(ArrayList<Integer> listThing) {
        for (int i=1; i<listThing.size(); i++) {
            if (listThing.get(i-1) > listThing.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean getUserTarget(){
        try{
        Scanner userinp = new Scanner(System.in);
        System.out.print("\n\nEnter an integer value for which to search in the provided list -->  ");
        target = userinp.nextInt();
        userinp.close();
        return true;
        }
        catch(InputMismatchException e){
            System.out.println("\nPlease enter an Integer.");
            return false;
        }
        

    }
}


