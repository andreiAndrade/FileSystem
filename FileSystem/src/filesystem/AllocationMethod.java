package filesystem;

import java.util.ArrayList;
import java.util.List;

public class AllocationMethod {
    
    public static void contiguousAllocation(List<Block> hd, File file) throws Exception {
        List<Integer> blocksForAloccation = new ArrayList<>();

        for (Block bHd : hd){
            if (bHd.isEmpty()) {
                blocksForAloccation.add(bHd.getIdBlock());
                if (blocksForAloccation.size() == file.getSize()) {
                    file.setFirstBlock(blocksForAloccation.get(0));
                    for (Block b : hd){
                        for (int i = 0; i < file.getSize(); i++){
                            if (b.getIdBlock() == blocksForAloccation.get(i)){
                                b.setEmpty(false);
                                b.setContents(file.getName().charAt(i));
                            }
                        }
                    }
                    return;
                }
            }
            else {
                blocksForAloccation.clear();
            }

        }
        throw new Exception();
    }

    public static void linkedAllocation(List<Block> hd, File f){
        int blockBefore = 0;
        
        int firstBlock = f.getFirstBlock();
        
        for (Block blockHD : hd) {
            if(blockHD.isEmpty() && blockHD.getIdBlock() == firstBlock) {
                blockHD.setContents(f.getName().charAt(0));
                blockHD.setEmpty(false);
                blockBefore = firstBlock;
            }
        }
        
        for (int i = 1; i < f.getSize(); i++) {
            for (Block blockHD : hd) {
                if (blockHD.isEmpty()) {
                    blockHD.setContents(f.getName().charAt(i));
                    blockHD.setEmpty(false);
                    
                    for (Block blockBef : hd ) {
                        if (blockBef.getIdBlock() == blockBefore) {
                            blockBef.setNextIndex(blockBef.getIdBlock());
                            blockBefore = blockHD.getIdBlock();
                        }
                    }
                }
            }
        }
    }
    
    public static void indexedAllocation(List<Block> hd, File f){
        List<Integer> index = new ArrayList<>();

        int indexBlock = f.getFirstBlock();;
        
        for (int i = 0; i < f.getSize(); i++) {
            for (Block blockHD : hd) {
                if (blockHD.isEmpty() && blockHD.getIdBlock() != indexBlock) {
                    blockHD.setContents(f.getName().charAt(i));
                    blockHD.setEmpty(false);
                    index.add(blockHD.getIdBlock());
                }
            }
        }
        
        for (Block blockHD : hd) {
            if (blockHD.getIdBlock() == indexBlock) {
                blockHD.setIndex(index);
            }
        }
    }
}

