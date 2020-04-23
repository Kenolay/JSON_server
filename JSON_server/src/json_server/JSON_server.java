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



public class JSON_server {
    public static void main(String[] args) throws IOException{             
        Fighter F1,F2;
        
        MySocket MS1 = new MySocket(3345);
        MS1.recieveMessage();
        System.out.println(MS1.getLine());
        
        MySocket MS2 = new MySocket(3346);
        MS2.recieveMessage();
        System.out.println(MS2.getLine());
        
        F1 = Network.JSONinFighter(MS1.getLine());
        F2 = Network.JSONinFighter(MS2.getLine());
        
        Fighter.battleRun(F1,F2,MS1,MS2);
         
        MS1.sendLine();
        MS2.sendLine();
         
        MS1.finishWork();
        MS2.finishWork();

    }
}