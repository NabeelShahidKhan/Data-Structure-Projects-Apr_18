
import java.security.MessageDigest;

public class HashTest {
	
	
	
	
    public static void main(String[] args){

    	String s = "1524405906978Genisis Block0";
    	  byte[] bytes = s.getBytes();
    	  StringBuilder binary = new StringBuilder();
    	  for (byte b : bytes)
    	  {
    	     int val = b;	//%23249425;
    	     for (int i = 0; i < 8; i++)
    	     {
    	        binary.append((val & 128) == 0 ? 0 : 1);
    	        val <<= 1;
    	     }
    	   //  binary.append(" ");
    	  }
    	  
    	  System.out.println("'" + (int) s.charAt(0) + "'\n to binary: " + binary);

    	  //String[] hex={"f","e","d","c","b","a","9","8","7","6","5","4","3","2","1"};
    	  int[] weight = {8,4,2,1};
    	  int inCont = 0;
    	  String[] hex={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    	  String hexdecnum="";
          
    	  int rem,x = 0;
    	  for(int i=0;i<binary.length();i++)
    	   {
    		  
    		  if(i%4 == 0 && i!=0)
    		  {
    			  hexdecnum += hex[x];
    			  inCont=0;
    	    	  x = 0;
    		  }
    		  else if(i>=binary.length()-1)
    			  hexdecnum += hex[x];
    	   
    	    rem = binary.charAt(i);
    		inCont++;
    	    if(rem ==49){
    	    	if(inCont==1){	x+=weight[0];	}
    	    	else if (inCont==2){	x+=weight[1];	}
    	    	else if (inCont==3){	x+=weight[2];	}
    	    	else if (inCont==4){	x+=weight[3];	}
    	    	
    	    }
    	   }
    	  System.out.println("\n to Hex: " + hexdecnum + "\n size: " + hexdecnum.length());
    	  }

    	public String getSHA256(String str) {	     
		    String encodedString = "";
		       int i=0;
		       while(i<str.length()){
		    	   int sum = (int) str.charAt(i) * 99; 
		    	   i++;
		       }
		    	
		       return encodedString;
		    	// return SHA256(str);
		    }

	private static String SHA256(String str) {
		MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (Exception e) {
            System.out.println("getSHA256 is error" + e.getMessage());
        }
        return encodeStr;
	}

    private static String byte2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                builder.append("0");
            }
            builder.append(temp);
        }
        return builder.toString();
    }
}
