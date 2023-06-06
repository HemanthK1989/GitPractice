package HemanthAcademy;

import org.testng.annotations.Test;

public class Java_String_IQ {
	//@Test
	/*
	 * public void rev2StringsandConcat() { // TODO Auto-generated method stub
	 * String str ="Hemanth Krishna"; String str4=""; String str5="";
	 * 
	 * String[] str1=str.split(" ");
	 * 
	 * String str2=str1[0]; String str3=str1[1];
	 * 
	 * for(int i=str2.length()-1;i>=0;i--) { str4=str4+str2.charAt(i);
	 * str5=str5+str3.charAt(i); }
	 * 
	 * String result = str4.concat(" "+str5); System.out.println(result); }
	 * 
	 * @Test public void reversecharsin2Strings() { String str ="Hemanth Krishna";
	 * String str4="";
	 * 
	 * String[] str1=str.split(" ");
	 * 
	 * String str2=str1[0]; String str3=str1[1];
	 * 
	 * for(int i=0;i<str2.length();i++) { str4=str4+str2.charAt(i)+str3.charAt(i); }
	 * System.out.println(str4);
	 * 
	 * }
	 */	
	@Test
	public void reverseString()
	{
		
		String name="Hemanth";
				String result="";

				for(int i=name.length()-1;i>=0;i--)
				{
				result =result+name.charAt(i);
				}

				System.out.println(result);

	}
}
