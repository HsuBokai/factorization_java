import java.io.IOException;
import java.util.Scanner;

class factorization{
	private static final short maxPrime = 10000;
	static short[] table = new short[(int)(maxPrime/5)];
	static int length = 0;
	//static boolean[] isPrime = new boolean[maxPrime];

	public static void main(String[] args) {
		 create();
		 Scanner cin = new Scanner(System.in);
		 System.out.printf("please enter a integer to be factorized: ");		 		 
		 while (cin.hasNextInt()) {
			 int in = cin.nextInt();
			 if(in==1) System.out.printf("%d", 1);
			 //else factorization(in);
			 boolean first = true;
				for(short i = 0; table[i]<=Math.sqrt(in); ++i){	
					 if(in%table[i]==0) {
						 if(first==false) System.out.printf(" * ");
						 first = false;
						 in = in/table[i];
						 System.out.printf("%d", table[i]);
						 if(in%table[i]==0){
							System.out.printf("^");
							int count = 1;
							do{
								++count;
								in = in/table[i];
							}while(in%table[i]==0);
							System.out.printf("%d", count);
						 }
					 }
				 }
				if(in!=1){
					if(first==false) System.out.printf(" * ");
					System.out.printf("%d", in);	
				}
				System.out.printf("\n");
				System.out.printf("please enter a integer to be factorized: ");
			 
		 }
	}
	private static void create(){
		table[length++] = 2;
		//isPrime[0]=false;
		//isPrime[1]=false;
		//isPrime[2]=true;
		for(short unknow = 3; unknow<maxPrime; ++unknow){
			boolean isPrime = true;
			for(short i = 0; table[i]<=Math.sqrt(unknow) && isPrime; ++i){
				if(unknow%table[i]==0) isPrime=false;
			}
			if(isPrime) table[length++] = unknow; 
		}
	}
}