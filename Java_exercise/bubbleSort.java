/*************************************************************************
 *
 * Creat by zengge 2016/03/20
 *
 * Ã°ÅÝÅÅÐò
 *
 * **********************************************************************/

public class bubbleSort {

	public static void main(String[] args) {
		int [] intArrary = new int[] {3,67,9,4,1,55,-1,22,-5,100};
		int temp;

		for(int j = intArrary.length; j > 0; j --) {
			for (int i = 0 ;i < intArrary.length - 1; i++){
				if (intArrary[i] > intArrary[i+1]){
					temp = intArrary[i];
					intArrary[i]  = intArrary[i + 1];
					intArrary[i + 1] = temp;
				}
			}
		}

		for(int n = 0 ;n <intArrary.length; n ++) {
			System.out.print(intArrary[n] + " ");
		}
	}

}
