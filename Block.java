public class Block {
	
    private int    index;
    private String previousHash;
    private long   timestamp;
    private String data;
    private String hash;

 // Constructor
  //=========================================================================================    
    public Block(int index, String previousHash, long timestamp, String data, String hash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }
 
    // Get/Set block index  Method
  //=========================================================================================    
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    
 // GET/SET previous hash vale String Method
  //=========================================================================================   
    public String getPreviousHash() {
        return previousHash;
    }
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }


 // GET/SET time stamp Method
  //=========================================================================================    
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
 
    
    // GET/SET Data Method
  //=========================================================================================     
   public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    
 // GET/SET hash vale Method
  //=========================================================================================    
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    
    
 // TO String Method
  //=========================================================================================    
    public String toString(){
    	String s="";
    		s+= "\t{"+"\n\t\tindex: "+(this.index-1) +
    				"\n\t\ttimeStamp : "+this.timestamp+
    				"\n\t\tdata : "+this.data+
    				"\n\t\tpriviousHash : "+this.previousHash+
    				"\n\t\tHash :\t\t"+this.getHash()+"\n\t}";
    		return s;
    }
    
}

