package filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    public ArrayList<Block> createHD(){
        List<Block> hd = new ArrayList<>();
        
        for(int i = 1; i <= 50; i++){
            hd.add(new Block(i));
        }
        
        return (ArrayList<Block>) hd;
    }
    
    public ArrayList<File> createFileListForContiguous(){
        List<File> fileList = new ArrayList<>();
        
        fileList.add(new File("Roben.txt", 2));
        fileList.add(new File("Teste.txt", 4));
        fileList.add(new File("Arquivo.doc", 6));
        fileList.add(new File("Musica123.mp3", 8));
        fileList.add(new File("Apresentacao.ppt", 6));
        fileList.add(new File("Pagina.html", 4));
        fileList.add(new File("Video.mpg", 2));
        fileList.add(new File("Documento.pdf", 4));
        
        return (ArrayList<File>) fileList;
    }
    
    public ArrayList<File> createFileListForIndexedAndLinked(){
        List<File> fileList = new ArrayList<>();
        
        fileList.add(new File("Roben.txt", 3, 2));
        fileList.add(new File("Teste.txt", 4, 4));
        fileList.add(new File("Arquivo.doc", 8, 6));
        fileList.add(new File("Musica123.mp3", 12, 8));
        fileList.add(new File("Apresentacao.ppt", 16, 6));
        fileList.add(new File("Pagina.html", 13, 4));
        fileList.add(new File("Video.mpg", 31, 2));
        fileList.add(new File("Documento.pdf", 24, 4));
        
        return (ArrayList<File>) fileList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
