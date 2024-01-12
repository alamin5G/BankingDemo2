package com.goonok;

import java.util.Scanner;

public class BankClient {
    private int current = -1;
    private Scanner input = new Scanner(System.in);
    private boolean done = false;


    private Bank bank = new Bank();

    public void run(){
        while(!done){
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
            int cmd = input.nextInt();
            processCommand(cmd);
        }
    }

   private void processCommand(int cmd){
       if(cmd==0) quit();
       else if (cmd==1) {
           newAccount();
       } else if (cmd==2) {
           select();
       } else if (cmd==3) {
           deposit();
       } else if (cmd==4) {
           authorizeLoan();
       }else if(cmd==5){
           showAll();
       } else if (cmd==6) {
           addInterest();
       } else{
           System.out.println("Illegal command");
       }
   }

   private void quit(){
       done = true;
       System.out.println("Good Bye");
   }

   private void newAccount(){
       current = bank.newAccount();
       System.out.println("Your new account number is: " + current);

   }

   
   private void select(){
       System.out.print("Enter account# ");
       current = input.nextInt();
       int balance = bank.getBalance(current);
       System.out.println("The balance of account " +current + " is " + balance);
   }

   private void deposit(){
       System.out.print("Enter depost amount: ");
       int amt = input.nextInt();
       bank.deposit(current, amt);
   }

   private void authorizeLoan(){
       System.out.println("Enter loan amount: ");
       int loanamt = input.nextInt();
       if (bank.authorizeLoan(current, loanamt)){
           System.out.println("Your loan is approved!");
       }else {
           System.out.println("Your loan is denied!");
       }
   }

   private void showAll(){
       System.out.println(bank.toString());
   }

   private void addInterest(){
        bank.addInterest();
   }

}
