package filesystem;

public class File {
    private String name;
    private int firstBlock;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public File(String name, int firstBlock, int size) {
        this.name = name;
        this.firstBlock = firstBlock;
        this.size = size;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFirstBlock() {
        return firstBlock;
    }


    public void setFirstBlock(int firstBlock) {
        this.firstBlock = firstBlock;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return "Name: " + name + " || Size: " + size;
    }
}
