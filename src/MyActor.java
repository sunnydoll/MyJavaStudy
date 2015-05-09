import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MyActor 
{
	
	public static void main(String[] args) throws IOException {

//		String str = "a2b3c2\r\ndf5";
//		String str = "the sky is blue";		
//		char[] ca = str.toCharArray();
//		reverseWords(ca);
//		System.out.println(ca);

		double i = Math.random();
		
//		File file = new File("readme.txt");
//		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
//		BufferedReader br = new BufferedReader(read);
//		String text = "";
//		while((text = br.readLine()) != null) {
//			System.out.println(text);
//		}

		String str = "aaabbccccdeef";
		String s = encodeStr(str);
		String s1 = decodeStr(s);
		System.out.println(s);
		System.out.println(s1);
		
//		StringBuilder sb = new StringBuilder(str);
//		System.out.println(str);
//		Character c = new Character('a');
//		System.out.println(Character.isAlphabetic(c));
		
//		int[] arr = new int[] {1,2,3,6,7,5,4,3,2};
//		System.out.println(FindArrayEle(arr));
	}
	
	public static String decodeStr(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		char cur = s.charAt(0);
		sb.append(cur);
		char pst;
		for(int i = 1; i < s.length(); i++) {
			pst = s.charAt(i);
			if(Character.isDigit(pst)) {
				int j = pst - '0';
				while(j > 1) {
					sb.append(cur);
					j = j - 1;
				}
			}
			else {
				cur = pst;
				sb.append(cur);
			}
		}		
		
		return sb.toString();
	}
	
	public static String encodeStr(String s) {
		
		if(s == null || s.length() == 0) {
			return s;
		}
		
		if(s.length() == 1) {
			return s + "1";
		}
		
		StringBuilder sb = new StringBuilder();
		char cur = s.charAt(0);
		sb.append(cur);
		int count = 1;
		char wlk;
		for(int i = 1; i < s.length(); i++) {
			wlk = s.charAt(i);
			if(cur == wlk) {
				count = count + 1;
			}
			else {
				sb.append(count);
				cur = wlk;
				sb.append(cur);
				count = 1;
			}
		}
		sb.append(count);
		return sb.toString();
	}
	
	public static void reverseWords(char[] ca) {
		reverse(ca, 0, ca.length);
		int i = 0;
		int j = 0;
		for(i = 0, j = 0; j <= ca.length; j++) {
			if(j == ca.length || ca[j] == ' ') {
				reverse(ca, i, j);
				i = j + 1;
			}
		}
	}
	
	public static void reverse(char[] ca, int st, int ed) {
		for(int i = 0; i < (ed - st) / 2; i++) {
			char temp = ca[st + i];
			ca[st + i] = ca[ed - i - 1];
			ca[ed - i - 1] = temp;
		}
	}
	
	public static int FindArrayEle(int[] array) {
		
		if(array == null || array.length == 0) {
			return -1;
		}
		
		if(array.length == 1) {
			return array[0];
		}
		
		int st = 0;
		int ed = array.length - 1;
		return FindArrayEle(array, st, ed);
		
	}
	
	public static int FindArrayEle(int[] array, int st, int ed) {
		
		if(st > ed) {
			return array[0];
		}
		
		if(st == ed) {
			return array[st];
		}
		
		int mid = (st + ed) / 2;
		if(array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
			return array[mid];
		}
		else if(array[mid] > array[mid + 1] && array[mid] < array[mid - 1]) {
			ed = mid;
			return FindArrayEle(array, st, ed);
		}
		else{
			st = mid;
			return FindArrayEle(array, st, ed);
		}
	}

	public static String numberComma(int num) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(num > 0) {
			int digit = num % 10;
			list.add(0, digit);
			num = num / 10;
		}
		System.out.println(list);
		for(int i = list.size() - 1; i >= 0; i--) {
			count++;
			sb.append(list.get(i));
			if(count % 3 == 0 && count <= list.size() - 1) {
				sb.append(',');
			}
		}
		sb = sb.reverse();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static int strStr(String haystack, String needle) {
        
        if(haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        
        if(haystack == null || haystack.length() == 0) {
            return -1;
        }
        
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        
        int lenHay = haystack.length();
        int lenNeed = needle.length();
        
        for(int i = 0; i < lenHay - lenNeed + 1; i++) {
            int j = 0;
            for(j = 0; j < lenNeed; j++) {
            	System.out.println(haystack.charAt(i) + " : " + needle.charAt(j));
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            System.out.println(j);
            if(j == lenNeed) {
                return i;
            }
        }
        
        return -1;
    }
	
	static int atoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        double res = 0;
        int i = 0;
        int len = str.length();
        boolean isNeg = false;
        if(str.charAt(0) == '-') {
            isNeg = true;
            i = 1;
        }
        else if(str.charAt(0) == '+') {
            isNeg = false;
            i = 1;
        }
        System.out.println(str);
        while(i < len) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                int a = (int)(c - '0');
                res = res * 10 + a;
                i++;
            }
            else {
                break;
            }
        }
        
        if(isNeg == true) {
            res = 0 - res;
        }
        System.out.println(res);
        
        if(res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        else if(res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        
        return (int)res;
    }
	
	static String addBinary(String a, String b) {
        if(a.length() == 0) {
            return b;
        }
        
        if(b.length() == 0) {
            return a;
        }
        
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(lenA > 0 && lenB > 0) {
            int na = (int)(a.charAt(lenA - 1) - '0');
            int nb = (int)(b.charAt(lenB - 1) - '0');
            int dig = na + nb + carry;
            carry = dig / 2;
            dig = dig % 2;
            res.append(dig);
            lenA--;
            lenB--;
        }
        
        while(lenA > 0) {
            int na = (int)(a.charAt(lenA - 1) - '0');
            int dig = na + carry;
            carry = dig / 2;
            dig = dig % 2;
            res.append(dig);
            lenA--;
        }
        while(lenB > 0) {
            int nb = (int)(b.charAt(lenB - 1) - '0');
            int dig = nb + carry;
            carry = dig / 2;
            dig = dig % 2;
            res.append(dig);
            lenB--;
        }
        
        if(carry > 0) {
            res.append(carry);
        }
        
        return res.reverse().toString();
    }
	
	static int reverse(int x) {
        if(x / 10 == 0) {
            return x;
        }
        boolean neg = false;
        int res = 0;
        if(x < 0) {
            x = 0 - x;
            neg = true;
        }
        while(x > 0) {
            int digit = x % 10;
            res = res * 10 + digit;
            x = x / 10;
        }
        if(neg) {
            res = 0 - res;
        }
        
        
        return res;
    }
	
	static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root != null && root.left == null && root.right == null) {
            return 1;
        }

        int depth = 1;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(list.size() > 0) {
        	ArrayList<TreeNode> helper = new ArrayList<TreeNode>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).left != null) {
                	helper.add(list.get(i).left);
                    System.out.println("left");
                }
                if(list.get(i).right != null) {
                	helper.add(list.get(i).right);
                    System.out.println("left");
                }
            }
            list = helper;
            if(list.size() > 0) {
                depth++;
            }
        }
        return depth;
    }
	
	static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        
        if(root == null) {
            return lists;
        }
        
        list.add(root.val);
        //lists.add(list);
        nodeList.add(root);
        if(root.left == null && root.right == null) {
            return lists;
        }
        
        while(nodeList.size() > 0) {
            //list.clear();
        	ArrayList<Integer> listTemp = new ArrayList<Integer>();
            ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();
            for(int i = 0; i < nodeList.size(); i++) {
                if(nodeList.get(i).left != null) {
                	System.out.println("left");
                    tempList.add(nodeList.get(i).left);
                    listTemp.add(nodeList.get(i).left.val);
                }
                if(nodeList.get(i).right != null) {
                	System.out.println("right");
                    tempList.add(nodeList.get(i).right);
                    listTemp.add(nodeList.get(i).right.val);
                }
            }
            nodeList = tempList;
            if(nodeList.size() > 0) {
                lists.add(listTemp);
            }
            //System.out.println(nodeList.size());
            System.out.println(lists.get(0).size());
        }
        System.out.println(lists.get(0).size());
        for(int i = 0; i < lists.size(); i++) {
        	for(int j = 0; j < lists.get(i).size(); j++) {
        		 System.out.println(lists.get(i).get(j));
        	}
        }
        return lists;
	}

	static void addParent(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
		if(leftRem < 0 || rightRem < leftRem) return;
		
		if(leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		}
		else {
			if(leftRem > 0) {
				str[count] = '(';
				addParent(list, leftRem - 1, rightRem, str, count + 1);
			}
			if(rightRem > leftRem) {
				str[count] = ')';
				addParent(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}
	
	static int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null) {
            return 0;
        }
        if(version1.length() == 0 && version2.length() > 0) {
            return -1;
        }
        if(version1.length() > 0 && version2.length() == 0) {
            return 1;
        }
        if(!version1.contains(".") && !version1.contains(".")) {
        	
        }
        
        String[] s1 = version1.split(".");
        String[] s2 = version2.split(".");
        int lenA = s1.length;
        int lenB = s2.length;
        
        int len = Math.min(lenA, lenB);
        for(int i = 0; i < len; i++) {
            int a = Integer.parseInt(s1[i]);
            int b = Integer.parseInt(s2[i]);
            System.out.println(a);
            System.out.println(b);
            if(a > b) {
                return 1;
            }
            else if(a < b) {
                return -1;
            }
            else {
                continue;
            }
        }
        
        if(lenA > lenB) {
            return 1;
        }
        else if(lenA == lenB) {
            return 0;
        }
        else {
            return -1;
        }
    }
	
	public static boolean isAdditiveNumber(String number)
    {
        for(int i = 1; i < number.length(); i++)
        {
            for(int j = i + 1; j < number.length(); j++)
            {
                int p1 = Integer.parseInt(number.substring(0, i));
                int p2 = Integer.parseInt(number.substring(i, j));
                int index= j;
                int rest  = Integer.parseInt(number.substring(j, number.length()));
                while(p1 + p2 <= rest)
                {
                    int p3 = p1 + p2;
                    String str = (new Integer(p3)).toString();
                    int length = str.length();
                    if(index + length > number.length())
                    {
                        break;
                    }
                    if(number.substring(index, index+length).equals(str))
                    {
                        index = length+index;
                        if(index == number.length())
                        {
                            return true;
                        }
                        p1 = p2;
                        p2 = p3;
                        rest = Integer.parseInt(number.substring(index, number.length()));
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return false;
    }
	
	public static void seedNum(int num) throws IOException {
//		System.out.println("Enter the number"); 
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		String number = br.readLine(); 
//		int num = Integer.parseInt(number); 
		for(int i = 1; i <= num; i++) 
		{ 
			//System.out.println("*" + i); 
			int count = 1; 
			int y = i; 
			count = count * y; 
			while(y >= 1) 
			{ 
				count = count * (y % 10); 
				y = y / 10; 
			} 
			//System.out.println(count); 
			if(count == num) 
			{ 
				System.out.println(i);
			}
		}
	}
	
	public static void phoneNumbers(int a1, int a2, int a3, int len){
		Vector<Integer> resVec = new Vector<Integer>();
		for(int i = 0; i < 10; i++){
			resVec.add(i);			
		}
		resVec.removeElement(Integer.valueOf(a1));
		resVec.removeElement(Integer.valueOf(a2));
		resVec.removeElement(Integer.valueOf(a3));
		System.out.println(resVec);
		for(int i = 0; i < resVec.size(); i++){
			organizePhoneNumbers(resVec, String.valueOf(resVec.get(i)), len);			
		}
	}
	
	public static void organizePhoneNumbers(Vector<Integer> resVec, String str, int len) {
		int k = 0;
		if(len != 0){
			k=0;
			String org = str;
			int temp = len;
			while(k < resVec.size()){
				str = org;
				len = temp;
				for(int i = k; i < k + len; i++){
					if(!str.equals("4") && resVec.get(i % resVec.size()) == 4){
						str = "4" + str;
						len--;
						// Bug here, if got 4 again, will put it to the head
					}
					else if(Integer.parseInt(str) == resVec.get(i % resVec.size())){
						len++;						
					}
					else{
						str = str + String.valueOf(resVec.get(i % resVec.size()));
						len--;
					}
//					System.out.println("Str: " + str);
//					System.out.println("Len: " + len);
				}
				System.out.println(str);
				k++;
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    res.add(new ArrayList<Integer>());
	    if(num == null || num.length == 0)
	        return res;
	    Arrays.sort(num);
	    int start = 0;
	    System.out.println(res.size());
	    for(int i = 0; i < num.length; i++)
	    {
	        int size = res.size();
	        System.out.println("Size: " + size);
	        for(int j = start; j < size; j++)
	        {
	        	System.out.println("Start: " + start);
	            ArrayList<Integer> newItem = new ArrayList<Integer>(res.get(j));
	            newItem.add(num[i]);
	            res.add(newItem);
	        }
	        if(i < num.length-1 && num[i] == num[i+1])
	        {
	            start = size;
	        }
	        else
	        {
	            start = 0;
	        }
	    }
	    return res;
	}
}
