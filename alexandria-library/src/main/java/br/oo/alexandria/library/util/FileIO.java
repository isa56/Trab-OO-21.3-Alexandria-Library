package br.oo.alexandria.library.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {

    public static String readFile(String path) throws FileNotFoundException {
        
        StringBuilder content = new StringBuilder();
        
        File file = new File(path);
        
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append('\n');
        }
        
        return content.toString();
        
    }
    
    public static void writeFile(String path, String content) {
        
        FileWriter writeFile;
        BufferedWriter bufferedFile;
        
        try {
            File file = new File(path);
            
            writeFile = new FileWriter(file, false);
            bufferedFile = new BufferedWriter(writeFile);
            
            bufferedFile.write(content + '\n');
            
            bufferedFile.close();
            writeFile.close();
        } catch(IOException e) {
            System.err.println("Erro para escrever no arquivo: " + e.toString());
        }
        
    }
    
}
