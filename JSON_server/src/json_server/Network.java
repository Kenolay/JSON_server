/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_server;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Network {
    static String createJSON(Fighter figter){     
        Gson g = new Gson();
        String jsonString = g.toJson(figter);
        
        System.out.println("\nТут будет вывод из класса JSon");            
        System.out.println(jsonString);
        return jsonString;
    }
    
    static Fighter JSONinFighter(String jsonString){     
        Gson g = new Gson();
        Fighter fighter_j = g.fromJson(jsonString, Fighter.class);
        fighter_j.printFighters();
        return fighter_j;
    }    
    
    static void writeFile(String line,String nameFile) throws IOException{
        //Запись в файл
        FileWriter writer = new FileWriter(nameFile, false);
        writer.write(line);
        writer.flush();
        System.out.println("Файл записан");
    }   
        
    static String readFile(String nameFile) throws IOException{   
        //Чтение из файла
        String contents = new String(Files.readAllBytes(Paths.get(nameFile)));
        System.out.println("contents");
        System.out.println(contents);
        return contents;
    }
    
}
