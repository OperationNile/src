package com.myNile.leet;

import java.math.BigInteger;

public class STRBGCountOfLengthN {

	public static void main(String[] args) {
		STRBGCountOfLengthN stg=new STRBGCountOfLengthN ();
		System.out.println(stg.getCountOfCompleteRange(3, 7));
	}

	public BigInteger numberOfStrobogramaticsForGivenDigits(int digitCount) {
		switch(digitCount){
		case 1: return new BigInteger("3");
		case 2: return new BigInteger("4");
		case 3: return new BigInteger("12");
		}
		BigInteger  sum=new BigInteger("0");
		BigInteger  prev3=new BigInteger("3");// 0,1,8
		BigInteger  prev2=new BigInteger("4");//11,69,88,96
		BigInteger  prev1=prev3.multiply(prev2);
		int currentIndex=4;
		while(currentIndex<=digitCount){
			BigInteger  sumVal=new BigInteger("0");
			
			if( (currentIndex & 1)==0){//even
				sumVal=prev2.multiply(new BigInteger("5"));
			}else{//odd
				sumVal=prev1.multiply(new BigInteger("3"));
			}
			currentIndex++;
			sum=sumVal;
			prev2=prev1;
			prev1=sumVal;
		}
		return sum;
	}

	public BigInteger getCountOfCompleteRange(int i, int j) {
		 if(i>j){
			 return new BigInteger("0");
		 }
		 
		 if(i==j){
			 return numberOfStrobogramaticsForGivenDigits(i);
		 }
		 if(j<4){
			 
			 BigInteger temp=new BigInteger("0");
			 while(i<=j){
				 temp=temp.add(numberOfStrobogramaticsForGivenDigits(i));
				 i++;
			 }
			 return temp;//1,3 and 2,3 or 1,2
		 }
		 
		 
		 BigInteger  wholeSum=new BigInteger("0"); 
		 
		 if(j<4){
			 while(i<=3){
				 wholeSum=wholeSum.add(numberOfStrobogramaticsForGivenDigits(i));
				 i++;
			 }
 		 }
		 
		 
		 BigInteger  sum=new BigInteger("0");
			BigInteger  prev3=new BigInteger("3");// 0,1,8
			BigInteger  prev2=new BigInteger("4");//11,69,88,96
			BigInteger  prev1=prev3.multiply(prev2);
			int currentIndex=4;
			while(currentIndex<=j){
				BigInteger  sumVal=new BigInteger("0");
				if( (currentIndex & 1)==0){//even
					sumVal=prev2.multiply(new BigInteger("5"));
				}else{//odd
					sumVal=prev1.multiply(new BigInteger("3"));
				}
				if(currentIndex>=i && currentIndex <=j){
					wholeSum=wholeSum.add(sumVal);
				}
				currentIndex++;
				sum=sumVal;
				prev2=prev1;
				prev1=sumVal;
			}
		 
		 return wholeSum;
		 
		 
	}

}
