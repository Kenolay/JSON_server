/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_server;

import java.util.ArrayList;
import java.util.Collections;


public class Fighter {
    
    private ArrayList<Integer> fighters = new ArrayList<>(8);
    private int port;  
    
    Fighter(){
        for(int i=0;i<8;i++){
            fighters.add(i, i+1);
        }
        Collections.shuffle(fighters);
    }
    
    public void printFighters(){
        for(int i=0;i<8;i++){
            System.out.println("Боец№ " + i +" со значением силы равной: " + fighters.get(i));
        }
        System.out.println();
    }
    
    public static void battleRun(Fighter first,Fighter second, MySocket MS1, MySocket MS2){
        int pts1=0, pts2=0;
        
        for(int i=0;i<8;i++){
            System.out.println("1->" + first.fighters.get(i) + " vs " + second.fighters.get(i) + "<-2");
            if(first.fighters.get(i)>second.fighters.get(i)){
                pts1++;
            }else if(first.fighters.get(i)<second.fighters.get(i)){
                pts2++;
            }else{}
        }
        System.out.println("Очки первого игрока: " + pts1);
        System.out.println("Очки второго игрока: " + pts2);
        if(pts1>pts2) {
            System.out.println("Первый игрок выиграл");
            MS1.setLine("You winner!!! Your pts= " + pts1 + " Your apponent pts= " + pts2);
            MS2.setLine("You loser!!! Your pts= " + pts2 + " Your apponent pts= " + pts1);
        }        
        else if(pts1<pts2){
            System.out.println("Второй игрок выиграл");
            MS1.setLine("You loser!!! Your pts= " + pts1 + " Your apponent pts= " + pts2);
            MS2.setLine("You winner!!! Your pts= " + pts2 + " Your apponent pts= " + pts1);
        }
        else {
            System.out.println("Ничья");
            MS1.setLine("A draw, then both lost!!! Your pts= " + pts1);
            MS2.setLine("A draw, then both lost!!! Your pts= " + pts2);
        }
    }
    
    public static void printSizeList(Fighter first){
        System.out.println(first.fighters.size());
    }
    public void setPort(int count){
        port=count;
    }
}
