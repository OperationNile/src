package com.myNile.leet;

import java.math.BigInteger;

public class STRBGCountInRange {
	NextStrobogramaticNumber nextSTRBG=new NextStrobogramaticNumber();
	STRBGCountOfLengthN lengthSum=new STRBGCountOfLengthN();
	STRBGCountOfIncompleteLength incomplete=new STRBGCountOfIncompleteLength();
	public static void main(String[] args) {

		STRBGCountInRange stg= new STRBGCountInRange();
		System.out.println(stg.count("234", "232344"));

		
	}

	public BigInteger count(String low, String high) {
		 BigInteger sum=new BigInteger("0");
		 /*both are strbg ==>b4 2nd = b4 1st +1
		  * 1st is strbg ==>b4 2nd = b4 1st
		  * 2nd is strbg ==>b4 2nd = b4 1st +1
		  * both are non strbg==>b4 2nd = b4 1st
		  */
		 
		 boolean isLowStrbg=StrobogramaticUtil.isStrobogramatic(low);
		 boolean isHighStrbg=StrobogramaticUtil.isStrobogramatic(high);

		 if(low.length()==high.length()){
			 
			 if(isLowStrbg && isHighStrbg){
				 BigInteger tillLow=incomplete.countTillSTRBG(low);
				 BigInteger tillHigh=incomplete.countTillSTRBG(high);
				 return tillHigh.subtract(tillLow).add(new BigInteger("1"));

			 }else if(isHighStrbg){
				 String nextSTRBGLow=nextSTRBG.getNextSTRBG(low);
				 
				 BigInteger tillLow=incomplete.countTillSTRBG(nextSTRBGLow);
				 BigInteger tillHigh=incomplete.countTillSTRBG(high);
				 return tillHigh.subtract(tillLow).add(new BigInteger("1"));
			 }else if(isLowStrbg){
				 
				 String nextSTRBGHigh=nextSTRBG.getNextSTRBG(high);
				 BigInteger tillHigh=null;
				 
				if( "".equals(nextSTRBGHigh)){
					tillHigh=lengthSum.numberOfStrobogramaticsForGivenDigits(high.length());
				 }else{
					 tillHigh=incomplete.countTillSTRBG(nextSTRBGHigh) ;
				 }
				
				 BigInteger tillLow=incomplete.countTillSTRBG(low);
				 
				 return tillHigh.subtract(tillLow);
			 }else{
				 
				 String nextSTRBGLow=nextSTRBG.getNextSTRBG(low);
				 String nextSTRBGHigh=nextSTRBG.getNextSTRBG(high);
				 
				 BigInteger tillHigh=null;
				 
					if( "".equals(nextSTRBGHigh)){
						tillHigh=lengthSum.numberOfStrobogramaticsForGivenDigits(high.length());
					 }else{
						 tillHigh=incomplete.countTillSTRBG(nextSTRBGHigh) ;
					 }
					 BigInteger tillLow=incomplete.countTillSTRBG(nextSTRBGLow);
					 
					 return tillHigh.subtract(tillLow);
			 }
			 
			 
		 }
		 
		 String strbgAfterLow="";
		 if(isLowStrbg){
			 strbgAfterLow=low;
		 }else{
			 strbgAfterLow=nextSTRBG.getNextSTRBG(low);
		 }
		 
		 if(!"".equals(strbgAfterLow)){
			 sum=sum.add(incomplete.getSTRBGsAfterLow(strbgAfterLow));
		 }
		 
		 
		 
		 String strbgAfterHigh="";
		 if(isHighStrbg){
			 strbgAfterHigh=high;
			 sum=sum.add(new BigInteger("1"));
		 }else{
			 strbgAfterHigh=nextSTRBG.getNextSTRBG(high);
		 }
		 
		 if("".equals(strbgAfterHigh)){
			 sum=sum.add(lengthSum.numberOfStrobogramaticsForGivenDigits(high.length()));
		 }else{
			 sum=sum.add(incomplete.getSTRBGsAfterHigh(strbgAfterHigh));

		 }
		 
		 BigInteger fullLensum=lengthSum.getCountOfCompleteRange(low.length()+1,high.length()-1);
		 
		 return sum.add(fullLensum);
	}

}
