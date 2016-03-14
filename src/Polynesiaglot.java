import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Polynesiaglot {
	public static void main(String[] agrs){
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("C-large-practice.in"));
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
				System.out.println("Case #"+i+": "+new Polynesiaglot().solution(sCurrentLine));
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
	
	public long solution(String str){
		String [] words = str.split(" ");
		long c = Long.parseLong(words[0]);
		long v = Long.parseLong(words[1]);
		int l = Integer.parseInt(words[2]);
		long result = helper(v,c,l);
		return result;
		
	}
	
	public long helper(long v, long c, int l){
		long [] array = new long[l+1];
		array[1] = v;
		if(array.length > 2){
			array[2] = v*v+c*v;
		}
		for(int i = 3; i <= l; i++){
			array[i] = (v*array[i-1] + c*v*array[i-2])%1000000007;
		}
		return array[l];
	}

}
