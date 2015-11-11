package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private int idBlock;
    private char contents;
    private boolean empty = true;
    private int nextIndex = 0;
    private List<Integer> index;

    public Block(int idBlock) {
        this.idBlock = idBlock;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
    }

    public char getContents() {
        return contents;
    }

    public void setContents(char contents) {
        this.contents = contents;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public List<Integer> getIndex() {
        return index;
    }

    public void setIndex(List<Integer> index) {
        this.index = index;
    }
}
