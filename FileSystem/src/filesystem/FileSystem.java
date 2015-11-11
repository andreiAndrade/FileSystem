package filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystem {

    //region StaticAttributes
    static List<Block> hd;
    static List<File> fileList = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    //endregion

    //region PrivateMethods
    private static ArrayList<Block> createHD() {
        List<Block> hd = new ArrayList();

        for (int i = 1; i <= 50; i++) {
            hd.add(new Block(i));
        }

        return (ArrayList<Block>) hd;
    }

    private static ArrayList<File> createFileListForContiguous() {
        List<File> fileList = new ArrayList();

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

    private static ArrayList<File> createFileListForIndexedAndLinked() {
        List<File> fileList = new ArrayList();

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

    private static void createBadBlocks(List<Block> hd) {

        Integer[] badBlocks = {10, 20, 30, 35, 50};

        for (Integer i : badBlocks) {
            for (Block b : hd) {
                if (b.getIdBlock() == i) {
                    b.setEmpty(false);
                    break;
                }
            }
        }
    }

    private static void showFileContiguous(File file) {
        int startingShow = file.getFirstBlock();
        int lastBlock = (startingShow + file.getSize());
        
        for(int i = startingShow; i < lastBlock; i++){
            System.out.print(hd.get(i).getContents());
        }
        System.out.println("");
        
//        for (Block b : hd) {
//            if (b.getIdBlock() >= startingShow)
//                System.out.print(b.getContents());
//            if (b.getIdBlock() > file.getFirstBlock() + file.getSize())
//                System.out.println("");
//            break;
//        }
    }
    
    private static void showFileLinked(File file) {
        int showBlock = file.getFirstBlock();
        System.out.println(hd.get(showBlock).getContents() + "primeiro");
        
        while(hd.get(showBlock).getNextIndex() != 0){
            System.out.println(hd.get(showBlock).getContents());
            showBlock = hd.get(showBlock).getNextIndex();
        }
    }

    private static void executeContiguous() {
        int option = 0;

        do {
            
//            for(Block b : hd){
//                        System.out.println(b.getIdBlock() + " - " + b.isEmpty() + " - " + b.getContents());
//                    }
            
            System.out.println("Arquivos:");

            //Lista Arquivos
            int index = 1;
            for (File f : fileList) {
                System.out.println(index++ + ". " + f.toString());
            }
            System.out.println("0. Trocar método");

            //Escolhe Arquivo para mostrar
            option = sc.nextInt();
            
            if( option > 0 && option <= (fileList.size()) ){
                
                try {
                    AllocationMethod.contiguousAllocation(hd, fileList.get(option-1));
                    showFileContiguous(fileList.get(option - 1));
                } catch (Exception e) {
                    System.out.println("Não foi possível armazenar o arquivo no HD.");
                }
            } else if(option == 0){
                System.out.println("Encerrando Método de alocação contigua...");
            } else {
                System.out.println("Comando Inválido! Tente novamente com outro valor.");
            }
        }while(option !=0);

        return;
    }
    
    private static void executeIndexed() {
        int option = 0;

        do {
            System.out.println("Arquivos:");

            //Lista Arquivos
            int index = 1;
            for (File f : fileList) {
                System.out.println(index++ + ". " + f.toString());
            }
            System.out.println("0. Trocar método");

            //Escolhe Arquivo para mostrar
            option = sc.nextInt();
            
            if( option > 0 && option < (fileList.size()-1) ){
                try {
                    AllocationMethod.indexedAllocation(hd, fileList.get(option-1));
//                    showFile(fileList.get(option - 1));
                } catch (Exception e) {
                    System.out.println("Não foi possível armazenar o arquivo no HD.");
                }
            } else if(option == 0){
                System.out.println("Encerrando Método de alocação contigua...");
            } else {
                System.out.println("Comando Inválido! Tente novamente com outro valor.");
            }
        }while(option !=0);

        return;
    }
    
    private static void executeLinked() {
        int option = 0;

        do {
            System.out.println("Arquivos:");

            //Lista Arquivos
            int index = 1;
            for (File f : fileList) {
                System.out.println(index++ + ". " + f.toString());
            }
            System.out.println("0. Trocar método");

            //Escolhe Arquivo para mostrar
            option = sc.nextInt();
            
            if( option > 0 && option < (fileList.size()) ){
                
                try {
                    AllocationMethod.linkedAllocation(hd, fileList.get(option-1));
                    showFileLinked(fileList.get(option - 1));
                } catch (Exception e) {
                    System.out.println("Não foi possível armazenar o arquivo no HD.");
                }
            } else if(option == 0){
                System.out.println("Encerrando Método de alocação contigua...");
            } else {
                System.out.println("Comando Inválido! Tente novamente com outro valor.");
            }
        }while(option !=0);

        return;
    }

    //endregion

    public static void main(String[] args) {

        //region Attributes


        hd = createHD();
        createBadBlocks(hd);

        int option;
        //endregion

        do {

            //region EscolheMetodo
            System.out.println("Método de Alocação:");
            System.out.println("1. Alocação Contígua;");
            System.out.println("2. Alocação Indexada;");
            System.out.println("3. Alocação Enadeada;");
            System.out.println("0. Sair.");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    fileList = createFileListForContiguous();
                    executeContiguous();
                    break;

                case 2:
                    fileList = createFileListForIndexedAndLinked();
                    executeIndexed();
                    break;

                case 3:
                    fileList = createFileListForIndexedAndLinked();
                    executeLinked();
                    break;

                default:
                    System.out.println("Comando inválido!");
            }
            //endregion

        } while (option != 0);

    }
}
