package middleLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//팩토리얼5란, N!의 0이 아닌 뒤 5자리를 말한다.
//N이 주어졌을 때, 팩토리얼5를 구하는 프로그램을 작성하시오.

//입력
//첫째 줄에 정수 N이 주어진다. N은 1,000,000보다 작거나 같다. 또, 9보다 크거나 같다.

//출력
//첫째 줄에 N의 팩토리얼5를 계산한다.

public class N1564 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number;
		try {
			number = Integer.parseInt(br.readLine());
			br.close();
			long facN = facT((long)number);

			System.out.println(String.format("%05d", facN));
			System.out.println((long)Math.pow(10, 12));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static long factorial(int n) {	//재귀함수 팩토리얼
		if(n == 1) {
			return 1;
		}
		return n * factorial(n-1) % 10000000;	
		//7자리로 나눌 경우 6자리가 보존됨. 이럴 경우 10으로 나눠도 5자리까지 보존이 된다.
		
		//n자리 숫자 * m자리 숫자 를 곱할 경우 결과는 최대 n+m자리 숫자가 되는데
		//n과m중 작은 자리수 -1의 값 까지는 값이 보존이 된다.
		//예를 들어 223 * 3896의 결과는 868,808이고 623 * 9596은 5,978,308이다. 
		//08, 즉 2자리 까지는 값이 동일하다. 여기서 223,623이 3자리 이므로 2자리 까지는 값이 보존된다.
	}
	
	public static long facT(long n) {		//재귀함수 안쓴 팩토리얼
		long fac5 = 1;
		if(n==1) {
			return 1;
		}
		for(int i = 2; i<=n; i++) {
			fac5 = fac5 * i;
			while(fac5%10 == 0) {
				fac5 = fac5/10;
			}
			fac5 = fac5 % (long)Math.pow(10, 7);
		}

		long facInt = fac5 % (long)Math.pow(10, 5);
		
		return facInt;
	}
	
}

/*놀라운사실
 *fac5 = fac5 *i
 *fac5 = fac5 % 1000000000000L; (0이 12개)
 *의 결과와
 *fac5 = (fac5 * i) fac5 % 1000000000000L과 결과가 다르다!
 *
 *pow(10,7)으로도 충분히 5자리 숫자 정확히 나오는데 왜 백준은 12를 해야 정답일까??????????????
 */
