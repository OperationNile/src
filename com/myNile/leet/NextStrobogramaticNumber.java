package com.myNile.leet;

public class NextStrobogramaticNumber {

	public static void main(String[] args) {
 
		NextStrobogramaticNumber next=new NextStrobogramaticNumber();
		
		System.out.println("990>>>"+next.getNextSTRBG("990"));
	}

	  String getNextSTRBG(String inp) {
		char[] arr=inp.toCharArray();
		int i=0,j=arr.length-1;
		boolean decreasedFlag=false;
		boolean outOfRange=false;
		
		while(i<=j+1){//j+1 required for even case when i and j crossed but still require back walk
	
			if(!StrobogramaticUtil.isSTRBGNumber(arr[i])){
				if(i==j){
					arr[i]=StrobogramaticUtil.getMatchingMidSTRBGNumber(arr[i]);
				}else{
					arr[i]=StrobogramaticUtil.nextSTRBGNumber4GivenNonSTRBGNumber(arr[i]);
				}
				
				arr[j]=StrobogramaticUtil.getMatchingSTRBGNumber(arr[i]);
				
				
				StrobogramaticUtil.convertToZeros(arr,i+1,j-1);
				break;
				
			}
			
			if(i<j){
				char tmp=arr[j];
				char jVal=StrobogramaticUtil.getMatchingSTRBGNumber(arr[i]);
				
				if(tmp>jVal){
					decreasedFlag=true;
				}
				
				arr[j]=jVal;
				i++;j--;
			}else if(i==j){// odd case
			
			  if(!decreasedFlag && StrobogramaticUtil.isValidMid(arr[i]) ){
				  break;
			  }else{
				  
				  char mid=arr[i];
				  char matchMid=StrobogramaticUtil.getMatchingMidSTRBGNumber(mid);
				  
				  if(matchMid!='0'){//just correcting mid is suffice
					  arr[i]=matchMid;
					  break;
				  }else{
					  int pos=StrobogramaticUtil.getPrevValidPosition(arr,j-1);
					  
					  if(pos<0){
						  outOfRange=true;
						  break;
					  }else{
						  StrobogramaticUtil.correctWithZeros(arr,pos);
						  break;
					  }
					  
					  
				  }
				  
			  }
			
			}else{//even case
				if(decreasedFlag){
					int pos=StrobogramaticUtil.getPrevValidPosition(arr, j);
					if(pos<0){
						outOfRange=true;
						break;
					}else{
						StrobogramaticUtil.correctWithZeros(arr, pos);
						break;
					}
				}else{
					break;
				}
			}
			
		}
		
		
		String res="";
		if(!outOfRange){
			res=new String(arr);
		}
		return res;
		
		
		
	}

}
