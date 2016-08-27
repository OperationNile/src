package com.myNile.leet;

import java.math.BigInteger;

public class STRBGCountOfIncompleteLength {

	STRBGCountOfLengthN lengthSum= new STRBGCountOfLengthN();
	
	public static void main(String[] args) {
		STRBGCountOfIncompleteLength stg= new STRBGCountOfIncompleteLength();
		
		System.out.println(stg.countTillSTRBG("8"));
	}

	public BigInteger countTillSTRBG(String strbgNum) {
 
	
	char[] inp=strbgNum.toCharArray();
	
	
	BigInteger sum=new BigInteger("0");
	int len=strbgNum.length();
	
	if((len & 1)==0){//even
		
		int u= len/2;
		int index=0;
		while(u>0){
			int rank=StrobogramaticUtil.getDigitRank(inp[index]-'0',index);
			
			BigInteger rankBI=new BigInteger(""+rank);
			BigInteger fiveBI=new BigInteger("5");

			BigInteger fiveBIPow=fiveBI.pow(u-1);
			sum=sum.add(rankBI.multiply(fiveBIPow));
			u--;
			index++;

		}
	}else{//odd
		
		
		if(len==1){
			int singleNum=Integer.valueOf(strbgNum);
			if(singleNum<1){
				return new BigInteger("0");
			}
			if(singleNum<8){
				return new BigInteger("1");
			}
			return new BigInteger("2");
		}
		int u= len/2;
		int index=0;
		
		while(u>0){
			int rank=StrobogramaticUtil.getDigitRank(inp[index]-'0',index);
			
			BigInteger rankBI=new BigInteger(""+rank);
			BigInteger fiveBI=new BigInteger("5");
			BigInteger threeBI=new BigInteger("3");
			BigInteger fiveBIPowMul3=fiveBI.pow(u-1).multiply(threeBI);
			sum=sum.add(rankBI.multiply(fiveBIPowMul3));
			u--;
			index++;
		}
		
		char mid=inp[len/2];
		if(mid=='1'){
			sum=sum.add(new BigInteger("1"));
		}
		
		if(mid=='8'){
			sum=sum.add(new BigInteger("2"));
		}
		
		
	}
	return sum;
	
	
	}

	public BigInteger getSTRBGsAfterLow(String strbgNum) {
		BigInteger tillSTRBG=countTillSTRBG(strbgNum);
		BigInteger wholeLen=lengthSum.numberOfStrobogramaticsForGivenDigits(strbgNum.length());
		return wholeLen.subtract(tillSTRBG);
	}

	public BigInteger getSTRBGsAfterHigh(String strbgNum) {
 		return countTillSTRBG(strbgNum);
	}

}
