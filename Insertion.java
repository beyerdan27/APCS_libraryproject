import java.util.Arrays;
public class Insertion{
	public static int[] arr = {0, -5, -3156, 6789, 31, 0, 0, 63, 724, 1};
	public static int temp=0;
	public static int j;
	public static void main(String[] args){
		for(int i=1; i<arr.length; i++){
			j=i;
			while(j>0&&arr[j-1]>arr[j]){
				swap(j, j-1);
				j-=1;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void swap(int indA, int indB){
	temp = arr[indA];
	arr[indA] = arr[indB];
	arr[indB] = temp;
	}
}
