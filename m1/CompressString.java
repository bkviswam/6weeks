import java.util.Arrays;

public class CompressString{

	public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        while(i<chars.length){
            int j = i;
            while(j<chars.length && chars[j]==chars[i]){
                j++;
            }
            chars[index++] = chars[i];
            
            if(j-i > 1){
               String s = j - i +"";
                for (char c : s.toCharArray()){
                    chars[index++] = c;
                }  
            }
            i = j;
        }
        //System.out.println(Arrays.toString(chars));
        return index;
    }

	public static void main(String[] args) {
		CompressString cs = new CompressString();
		char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println("The length of the compressed String : "+cs.compress(chars));
	}
}