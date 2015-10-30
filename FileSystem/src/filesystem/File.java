/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

/**
 *
 * @author aluno
 */
public class File {
    private String name;
    private int firstBlock;
    private int totalBlocks;

    public File(String name, int totalBlocks) {
        this.name = name;
        this.totalBlocks = totalBlocks;
    }

    public File(String name, int firstBlock, int totalBlocks) {
        this.name = name;
        this.firstBlock = firstBlock;
        this.totalBlocks = totalBlocks;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the firstBlock
     */
    public int getFirstBlock() {
        return firstBlock;
    }

    /**
     * @param firstBlock the firstBlock to set
     */
    public void setFirstBlock(int firstBlock) {
        this.firstBlock = firstBlock;
    }

    /**
     * @return the numberOfBlocks
     */
    public int getNumberOfBlocks() {
        return totalBlocks;
    }

    /**
     * @param numberOfBlocks the numberOfBlocks to set
     */
    public void setNumberOfBlocks(int numberOfBlocks) {
        this.totalBlocks = numberOfBlocks;
    }
}
