package code;

import java.util.Scanner;

public class StringManipulationAssignment {

	 public static int getLength(String st) 
	 {
		 return st.length();
	 }
	 
	public static int letterCount(String st, char ch)
	{
		int occurances = 0;
		
		for(int x = 0; x < st.length(); x++)
		{
			if(st.charAt(x) == ch)
			{
				occurances++;
			}
		}
				
		return occurances;
	}
	
	public static String reverse(String st) 
	{
		String reverse = "";
		
		for(int x = st.length(); x > 0; x--)
		{
			reverse += st.charAt(x-1);
		}
		
		return reverse;
	 }
		
	public static boolean isAnagram(String st1, String st2)
	{
		if(st1.length() != st2.length())
		{
			return false;
		}
		
		char[] word1 = st1.toCharArray();
		char[] word2 = st2.toCharArray();
		
		/* another way for string to char array 
		char[] word2 = new char[st2.length];
		for(int x = 0; x < st2.length(); x++)
			word2[x] = st2.charAt(x);
		*/ 
		
		boolean letterFound = false;
		for(int x = 0; x < st1.length(); x++)
		{
			letterFound = false;
			for(int y = 0; x < st2.length(); y++)
			{
				if(word1[x] == word2[y])
				{
					letterFound = true;
					word2[y] = '~'; //removing so doesn't count twice for duplicates 
					break;
				}
			}
			
			if(letterFound = false) // or if !letterFound 
			{
				return false;
			}
		} 
		
		return true;
	}
	
	public static String pigLatin(String st) 
	{
		String pigLatin = "";
		
		pigLatin = st.substring(1, st.length() - 1) + st.charAt(0) + "ay";
		
		return pigLatin;
	}
	
	public static String removeDuplicates(String st) {
		String removeDuplicates = "";
		
		for(int x = 0; x < st.length(); x++)
		{
			char ch = st.charAt(x);
			
				if(st.indexOf(ch) == x)
				{
					removeDuplicates += ch; 
				}
		}
		
		return removeDuplicates;
		
		/* other method 
		char[] word = st.toCharArray();
		
		for(int x = 0; x < word.length-1; x++)
		{
			for(int y = x+1; y < word.length; y++)
				if(word[x] == word[y])
					word[y] = '~';
		}
		
		String newWord = "";
		for(int x = 0; x < word.length; x++)
		{
			if(word[x] != '~')
				newWord += word[x];
		}
		
		return newWord;
		*/
	}
	
	/*The following method takes a string of 1's and 0's and compresses it by
	making a new string in the following way:
	1. The new string will start with the first character (either 1 or 0) in the
	string
	2. The next character will be a number showing how many of that digit appeared
	in a row before the opposite digit appeared.
	3. The next character will be a number showing how many of the opposite digit
	appeared in a row before the first digit appeared again.
	4. Go to step 2 and keep repeating until the whole string is compressed.
	Sample input: 111111111111000000001111111110000110001111000
	Sample output: 1 12 8 9 4 2 3 4 3
	*/
	public static String compression(String st) 
	{
		String compression = "";
		
		int count = 0;
		char ch = st.charAt(0);
		int index = 0;
		
		compression += ch;
		
		for(int y = 0; y < st.length(); y++)
		{
			count = 0;
			
			for(int x = 0 + index; x < st.length(); x++)
			{
				if(st.charAt(x) == ch)
				{
					count++;
				}
				
				else
				{
					break;
				}
			}
			
			if(count == 0)
			{
				break;
			}
			
			compression += " ";
			compression += count;
			index += count;
			
			if(ch == '1')
			{
				ch = '0';
			}
			else 
			{
				ch = '1';
			}
		}
		
		return compression;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testNumber = input.nextInt();
		if(testNumber == 1){
		String st = input.next();
		System.out.println( getLength(st) );
		}
		else if(testNumber == 2){
		String st = input.next();
		System.out.println( letterCount(st, 'p'));
		System.out.println( letterCount(st, 'b'));
		System.out.println( letterCount(st, 'a'));
		}
		else if(testNumber == 3){
		String st = input.next();
		System.out.println( reverse(st) );
		}
		else if(testNumber == 4){
		String s1 = input.next();
		String s2 = input.next();
		System.out.println( isAnagram(s1, s2) );
		}
		else if(testNumber == 5){
		String st = input.next();
		System.out.println( pigLatin(st) );
		}
		else if (testNumber == 6){
		String st = input.next();
		System.out.println( removeDuplicates(st) );
		}
		else if(testNumber == 7){
		String st = input.next();
		System.out.println( compression(st) );
		}
	}
}