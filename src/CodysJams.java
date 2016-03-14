import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CodysJams {
	public static void main(String[] agrs){
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("A-small-practice.in"));
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
				System.out.println("Case #"+i+":"+new CodysJams().solution(sCurrentLine, num));
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
	public String solution(String input, String num){
		String output = "";
		int n = Integer.parseInt(num);
		String [] words = input.split(" ");
		for(int i = 0; i < words.length; i++){
			for(int j = i+1; j < words.length; j++){
				long iv = Long.parseLong(words[i]);
				long jv = Long.parseLong(words[j]);
				if(iv*4/3 == jv && iv != 0 && jv != 0){
					output += " " +iv;
					words[j] = "0";
					j = words.length;
					n--;
					if(n <= 0){
						break;
					}
				}
			}
		}
		return output;
	}
}
