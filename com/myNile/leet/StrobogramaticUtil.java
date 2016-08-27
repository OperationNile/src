package com.myNile.leet;

import java.math.BigInteger;

public class StrobogramaticUtil {

	public static boolean validate(String low, String high) {

		if(!isDigitOnly(low) || !isDigitOnly(high)){
			return false;
		}
		if( (low.startsWith("0") && low.length()>1) || high.startsWith("0")){
			return false;
		}
		
		if(!isHighGtLow(low,high)){
			return false;
		}
		return true;
	}

	private static boolean isHighGtLow(String low, String high) {
		if(low.length()>high.length()){
			return false;
		}else{
			BigInteger low1=new BigInteger(low);
			BigInteger high1=new BigInteger(high);
			
			if(low1.compareTo(high1)!=-1){
				return false;
			}
		}
 		return true;
	}

	private static boolean isDigitOnly(String inp) {
		 char[] arr=inp.toCharArray();
		 
		 for(int i=0;i<arr.length;i++){
			 int tmp=arr[i]-'0';
			 if(tmp<0 || tmp>9){
				 return false;
			 }
		 }
		 
		return true;
	}

	public static boolean isSTRBGNumber(char i) {
		return i=='0' || i=='1' || i=='6' || i=='8' || i=='9' ;
	}

	public static char getMatchingMidSTRBGNumber(char i) {
		 if(i<='1') return '1';
		 if(i<='8') return '8';
		 return '0';
	}

	public static char nextSTRBGNumber4GivenNonSTRBGNumber(char i) {
		if(i=='7') return '8';
		return '6';
	}

	public static  char getMatchingSTRBGNumber(char i) {
	
		if(i=='6') return '9';
		if(i=='9') return '6';
		return i;
		
	}

	public static void convertToZeros(char[] arr, int i, int j) {
		while(i<=j){
		arr[i]='0';
		i++;
		}
	}

	public static boolean isValidMid(char i) {
		return i=='0' || i=='1' || i=='8'  ;
	}

	public static int getPrevValidPosition(char[] arr, int j) {
		 
		int pos=-1;
		while(j>=0){
			if(arr[j]=='9'){
				j--;
			}else{
				pos=j;
				break;
			}
		}
		return pos;
		
	}

	public static void correctWithZeros(char[] arr, int pos) {
     int jPos=arr.length-pos-1;
     arr[pos]=nextSTRBGDigit(arr[pos]);
     arr[jPos]=getMatchingSTRBGNumber(arr[pos]);
     convertToZeros(arr, pos+1, jPos-1);
	}

	 static char nextSTRBGDigit(char i) {
		if(i<'1')  return '1';
		if(i<'6')  return '6';
		if(i<'8')  return '8';
		return '9';
	}

	public static boolean isStrobogramatic(String input) {
		
		int low=0;
		int high=input.length()-1;
		while(low<high){
			String cur=input.charAt(low++)+""+input.charAt(high--);
			if(!"116968800".contains(cur)){
				return false;
			}
		}
		return true;
	}

	public static int getDigitRank(int i, int index) {
		int rank=0;
		
		if(index==0){
			switch(i){
			case 1:rank=1;break;
			case 6:rank=2;break;
			case 8:rank=3;break;
			case 9:rank=4;break;
			}
		}else{
			switch(i){
			case 0:rank=1;break;
			case 1:rank=2;break;
			case 6:rank=3;break;
			case 8:rank=4;break;
			case 9:rank=5;break;
			}
		}
 		return rank-1;
	}

}
