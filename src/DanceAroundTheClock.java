import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DanceAroundTheClock {
	
	public static void main(String[] agrs){
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("B-large-practice.in"));
			int i = 1;
			String num = "";
			boolean isFirst = true;
			while ((sCurrentLine = br.readLine()) != null) {
				String [] words = sCurrentLine.split(" ");
				if(isFirst){
					isFirst = false;
					continue;
				}
				if(words.length == 1){
					num = words[0];
					continue;
				}
				System.out.println("Case #"+i+":"+new DanceAroundTheClock().solution(sCurrentLine));
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	
	}

	public String solution(String input){
		String [] words = input.split(" ");
		long D = Long.parseLong(words[0]);
		long K = Long.parseLong(words[1]); //number of that particular dancer
		long N = Long.parseLong(words[2]);
		long left = K-1;
		long right = K+1;
		if(left <= 0){
			left += D;
		}
		if(right > D){
			right -=D;
		}
		String str = "";
		long z = 2*N%D;
		if(K%2 == 0){
			left -= z;
			right -= z;
			while(left <= 0) {left += D;}
			while(right <= 0) {right += D;}
		}
		else{
			left += z;
			right += z;
			while(left > D) {left -= D;}
			while(right > D) {right -=D;}
		}
		str+=" "+right+" "+left;
		
		return str;
	}
	

}
