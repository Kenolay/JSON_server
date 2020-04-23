/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MySocket {
    
    private int port; // случайный порт (может быть любое число от 1025 до 65535)
    private String line;
    private DataInputStream in;
    private DataOutputStream out; 
    
    
   // private ServerSocket ss;
    MySocket(int newPort){
        try{
        port = newPort;    
        ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
         System.out.println("Waiting for a client...");

         Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
         System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
         System.out.println();

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();
        in = new DataInputStream(sin);
        out = new DataOutputStream(sout);
        } catch(Exception x) { x.printStackTrace(); }
    }
    
    public DataInputStream getInputStream(){
        return in;
    }
    
    public DataOutputStream getOutputStream(){
       return out;
    }
         
        public void recieveMessage() throws IOException{
            try{
            line=in.readUTF();
            System.out.println("Получил сообщение от клиента");
            }catch(IOException ex){System.out.print("Не удалось получить сообщение от клиента");}
        }
        
        public String getLine(){
            return line;
        }
        
        public void setLine(String message){
            line = message;
        }
        public void sendLine() throws IOException{
           try{
               System.out.println("I'm sending result...");
               out.writeUTF(line); // отсылаем клиенту результат.
               out.flush(); // заставляем поток закончить передачу данных.
               System.out.println("Done!");
           }catch(IOException ex){System.out.print("Не удалось отправить сообщение клиенту");}
        }
        
        public void finishWork() throws IOException {
            in.close();
            out.close();           
        }
        
}
