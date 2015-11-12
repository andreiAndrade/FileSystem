package filesystem;

import java.util.ArrayList;
import java.util.List;

public class AllocationMethod {

    public static void contiguousAllocation(List<Block> hd, File file) throws Exception {
        List<Integer> blocksForAloccation = new ArrayList();

        for (Block bHd : hd){
            if (bHd.isEmpty()) {
                blocksForAloccation.add(bHd.getIdBlock());
                if (blocksForAloccation.size() == file.getSize()) {
                    file.setFirstBlock(blocksForAloccation.get(0) - 1);
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

    public static void linkedAllocation(List<Block> hd, File f) throws Exception {
        Block blockBefore;
        
        Block firstBlock = hd.get(f.getFirstBlock() - 1);

        if (firstBlock.isEmpty()){
            firstBlock.setContents(f.getName().charAt(0));
            hd.get(f.getFirstBlock() - 1).setEmpty(false);
            blockBefore = firstBlock;
        } else{
            throw new Exception("Bloco de início do arquivo não está disponível!");
        }

        boolean complete = false;
        for (int i = 0; i < f.getSize(); i++) {
            for (Block blockHD : hd) {
                if (blockHD.isEmpty()) {
                    blockHD.setEmpty(false);
                    blockHD.setContents(f.getName().charAt(i + 1));

                    blockBefore.setNextIndex(blockHD.getIdBlock());
                    blockBefore = blockHD;

                    complete = true;
                    break;
                }

                complete = false;
            }
        }

        if (!complete){
            throw new Exception("Não há espaço suficiente em disco!");
        }
    }
    
    public static void indexedAllocation(List<Block> hd, File f) throws Exception {
        List<Integer> index = new ArrayList();

        int indexBlock = f.getFirstBlock();

        if (hd.get(indexBlock - 1).isEmpty()) {
            boolean complete = false;
            for (int i = 0; i < (f.getSize() - 1); i++) {
                for (Block blockHD : hd) {
                    if (blockHD.isEmpty() && blockHD.getIdBlock() != indexBlock) {
                        blockHD.setContents(f.getName().charAt(i));
                        blockHD.setEmpty(false);
                        index.add(blockHD.getIdBlock());
                        complete = true;
                        break;
                    }
                    complete = false;
                }
            }
            if (!complete) throw new Exception("Não há espaço suficíente para alocar o arquivo!");
            hd.get(indexBlock - 1).setIndex(index);
        } else throw new Exception("Bloco de indices indíponivel!");
    }
}

