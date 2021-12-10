package com.aspiration.collection;

/**
 * Write a function that capitalizes *only* the nth alphanumeric character of a string, so that if I hand you

Aspiration.com

and I ask you to capitalize every 3rd character, you hand me back

asPirAtiOn.cOm

If I ask you to capitalize every 4th character, you hand me back

aspIratIon.cOm

Please note: 
- Characters other than each third should be downcased
- For the purposes of counting and capitalizing every three characters, consider only alphanumeric
  characters, ie [a-z][A-Z][0-9].
 *
 */

public class StringManipulation {
	
	
	public String manipulateString(String inputStr, int count) {
		
		if(inputStr == null || inputStr.length() <1 || count == 0){
			return inputStr;
		}
		
		StringBuilder str = new StringBuilder(inputStr.toLowerCase());
		
		int index = 1;
		
		for(int i=0;i< str.length();i++) {
			
		   if(!Character.isLetterOrDigit(str.charAt(i))) {
			   continue;
		   }
		   
		   if(index >= count && index % count == 0) {
			   char ch =str.charAt(i); 
			   str.setCharAt(i, Character.toUpperCase(ch));
		   }
		   index++;
		   
		}
		return str.toString();
	}

}
