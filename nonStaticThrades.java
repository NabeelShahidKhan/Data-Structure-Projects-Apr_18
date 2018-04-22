
public class nonStaticThrades {
	
	public nonStaticThrades(){
		
		
			BlockChain blockChain = new BlockChain();
			
			//	Block genisisBlock =  blockChain.getLatestBlock();
			
				Thread t = new Thread(new Runnable(){
					@Override
					public void run() {
						Block newBlock1 = blockChain.generateNextBlock("aaaaaaaa");
						blockChain.addBlock(newBlock1);
						
						Block newBlock2 = blockChain.generateNextBlock("bbbbbbbb");
						blockChain.addBlock(newBlock2);
					}
				});
			
				
				Thread t2 = new Thread(new Runnable(){
					@Override
					public void run() {
						Block newBlock7 = blockChain.generateNextBlock("cccccccc");
						blockChain.addBlock(newBlock7);

						Block newBlock5 = blockChain.generateNextBlock("dddddddd");
						blockChain.addBlock(newBlock5);				
					
						Block newBlock6 = blockChain.generateNextBlock("eeeeeee");		
						blockChain.addBlock(newBlock6);				
					
					}
				});
						
				t.start();
				try {
					t.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				t2.start();
				try {
					t2.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				

				System.out.println(blockChain.toString());
				
				
			
		}
}
