/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Block {
    private int idBlock;
    private char contents;
    private boolean empty;
    private int nextIndex;
    private List<Integer> index;

    public Block(int idBlock) {
        this.idBlock = idBlock;
    }

    /**
     * @return the idBlock
     */
    public int getIdBlock() {
        return idBlock;
    }

    /**
     * @param idBlock the idBlock to set
     */
    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
    }

    /**
     * @return the contents
     */
    public char getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(char contents) {
        this.contents = contents;
    }

    /**
     * @return the empty
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * @param empty the empty to set
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    /**
     * @return the nextIndex
     */
    public int getNextIndex() {
        return nextIndex;
    }

    /**
     * @param nextIndex the nextIndex to set
     */
    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    /**
     * @return the index
     */
    public List<Integer> getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(List<Integer> index) {
        this.index = index;
    }
}
