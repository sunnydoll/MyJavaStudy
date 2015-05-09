import java.util.HashMap;

public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuffer target = new StringBuffer();
        System.out.println(ss[0]);
        System.out.println(ss[1]);
        if(ss.length == 1)
            target.append(ss[0]);
        else
        {
        	HashMap<Double,Integer> map = new HashMap<Double,Integer>(); 
            for(int i = ss.length - 1; i >= 0; i--)
            {
                target.append(ss[i]);
            	if(i != 0 && ss[i - 1].length() > 0) {
            		target.append(" ");
            	}
            }
        }
        return target.toString();
    }
}