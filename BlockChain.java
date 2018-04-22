
import java.util.ArrayList;
import java.util.List;


public class BlockChain {

	private List<Block> blockChain;
	
// Constructor 
	//=========================================================================================    
    public BlockChain() {
        this.blockChain = new ArrayList<Block>();
        blockChain.add(this.getFristBlock());
    }
    
 // make string of block data and send it for calculate hash value to hash function
  //=========================================================================================    
    private String calculateHash(int index, String previousHash, long timestamp, String data) {
        StringBuilder builder = new StringBuilder(index);
        builder.append(previousHash).append(timestamp).append(data);
 
        // Alteration in String builder to minimize the size of Hash Vale
    //============================================================================================================================================   
    //    builder.append(previousHash.substring(0, previousHash.length()/100)).append(timestamp).append(data.substring(0,data.length()/9999));
        System.out.println(builder);
    //============================================================================================================================================
 
        return HashFunction.getSHA256(builder.toString());
    }
    
    
 // return last block Method
  //=========================================================================================    
    public Block getLatestBlock() {
        return blockChain.get(blockChain.size() - 1);
    }

    
 // Create first block of block chain Method
  //=========================================================================================    
    private Block getFristBlock() {
        return new Block(1, "0", System.currentTimeMillis(), "Genisis Block", "aa212344fc10ea0a2cb885078fa9bc2354e55efc81be8f56b66e4a837157662e");
    }
    
    
 // Create new Block Method
  //=========================================================================================    
   
    public Block generateNextBlock(String blockData) {
        Block previousBlock = this.getLatestBlock();
        int nextIndex = previousBlock.getIndex() + 1;
        long nextTimestamp = System.currentTimeMillis();
        String nextHash = calculateHash(nextIndex, previousBlock.getHash(), nextTimestamp, blockData);
        return new Block(nextIndex, previousBlock.getHash(), nextTimestamp, blockData, nextHash);
    }
    
    
 // Add new Block Method
  //=========================================================================================    
   
    public void addBlock(Block newBlock) {
        if (isValidNewBlock(newBlock, getLatestBlock())) {
            blockChain.add(newBlock);
        }
    }

    
 // Check is new block is valid or not and print error massages  
  //=========================================================================================      
    private boolean isValidNewBlock(Block newBlock, Block previousBlock) {
        if (previousBlock.getIndex() + 1 != newBlock.getIndex()) {
            System.out.println("invalid index: " + newBlock.getIndex() +"  Data: "+newBlock.getData());
            return false;
        } else if (!previousBlock.getHash().equals(newBlock.getPreviousHash())) {
            System.out.println("invalid previoushash");
            return false;
        } else {
            String hash = calculateHash(newBlock.getIndex(), newBlock.getPreviousHash(), newBlock.getTimestamp(),
                    newBlock.getData());
            if (!hash.equals(newBlock.getHash())) {
                System.out.println("invalid hash: " + hash + " " + newBlock.getHash());
                return false;
            }
        }
        return true;
    }

    public List<Block> getBlockChain() {
        return blockChain;
    }
    

 // TO String Method
//=========================================================================================    
    public String toString(){
    	String s="{\n"+"\""+this.getClass().getTypeName()+"\"";
    	for(int i=0;i<blockChain.size();i++)
    	{
    		s+="\n\tBlock # "+i+"\n"+this.blockChain.get(i).toString()+"\n";
    	}       
    	if(s!="")
    		s+="\n}";
    	return s;
    }
    
}
	