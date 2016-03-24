/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Vinu
 */
class Shop {
    String itemName;
    int itemQuantity;
    int itemPrice;
    void itemDescription(int i) throws IOException{
    System.out.println("Item no"+" "+i+":");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Item name:");
    itemName = br.readLine(); 
    System.out.println("Quantity:");
    itemQuantity = Integer.parseInt(br.readLine());
    System.out.println("Price per peice");
    itemPrice = Integer.parseInt(br.readLine());
    }
}

class PrintStock extends Shop{
    void print(int i){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(i+"            "+itemName+"           "+itemQuantity+"                "+itemPrice);
    }
}

class Billing extends PrintStock{
    void itemBilling(int j,int k){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(j+"            "+itemName+"                 "+k+"                     "+itemPrice+"*"+k);
    itemQuantity = itemQuantity-k;
    }
}

class PrintBill extends Billing{
    void printB(int i, int k) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(i+"            "+itemName+"                 "+k+"             "+itemPrice+"*"+k);
    }
}

public class Program3 {
    public static void main(String args[]) throws IOException{
        int count = 1,choice =0;
        int[] j = new int [100];
        int[] k = new int [100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the number of items in the shop");
        int no = Integer.parseInt(br.readLine());
        PrintBill[] obj = new PrintBill[no];
        for(int i=0;i<no;i++)
        {
            obj[i] = new PrintBill();
            obj[i].itemDescription(i);
        }
        while(choice!=999){
        System.out.println("1. Print Stock");
        System.out.println("2. Billing");
        System.out.println("999. Quit");
        System.out.println("Enter your choice");
        choice = Integer.parseInt(br.readLine());
        if(choice == 1)
        {
          System.out.println("SL.No:    Item:      Quantity:       Price:");
          for(int i=0;i<no;i++)
          {
            obj[i].print(i);
          }
        }
        else if(choice == 2)
        {   
            int _choice = 1;
            
            while(_choice != 0){
            
            System.out.print("Enter the SL.No of the item");
            j[count] = Integer.parseInt(br.readLine());
            System.out.print("Quantity");
            k[count] = Integer.parseInt(br.readLine());
            obj[j[count]].itemBilling(j[count],k[count]);
            count++;
            System.out.println("Enter 0 - stop billing and 1 - continue billing");
            _choice = Integer.parseInt(br.readLine());
            }
            
            if(_choice == 0){
                System.out.println("The Bill:");
                System.out.println("SL.No:    Item:      Quantity:       Price:");
                for(int i=1;i<=(count-1);i++)
                {
                  obj[j[i]].printB(j[i],k[i]); 
                }
          }
        }
      }
   }
}
