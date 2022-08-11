package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P029_SWEA5215_햄버거다이어트 {
	static int [] kal;
	static int [] pref;
	static int L;
	static int max = 0;
	static boolean [] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test<T+1;test++) {
			StringBuilder sb = new StringBuilder();
			String [] nl = br.readLine().split(" ");
			int N = Integer.parseInt(nl[0]);
			L = Integer.parseInt(nl[1]); 
			
			kal = new int [N];
			pref = new int [N];   // 칼로리와 선호도를 담을 배열
			isVisited = new boolean[N];
			for (int i = 0; i < N; i++) {
				String [] kp = br.readLine().split(" ");
				pref[i] = Integer.parseInt(kp[0]);
				kal[i] = Integer.parseInt(kp[1]);
			} // 입력부 마무리
			recursion(kal,pref,0,0,L);
			
			
			sb.append("#").append(test).append(" ").append(max).append("\n");
			System.out.print(sb);
		}

	}
	
	public static void recursion(int[] kal,int[] pref, int total_kal, int total_pref,  int L) {
		if(total_kal > L) return;  // L 보다 작거나 같아야 재귀가 돌아간다. - > 돌리고 나서 바로 커지는거면 멈춰야 되는데
		for (int i = 0; i < kal.length; i++) {
			if(!isVisited[i]) {
				if(total_kal + kal[i]> L) {
					max = Math.max(max, total_pref);
				}else {
					isVisited[i] = true;
					recursion(kal,pref, total_kal + kal[i], total_pref + pref[i], L);
					isVisited[i] = false;
				}
				
			}
		}
	}

}
