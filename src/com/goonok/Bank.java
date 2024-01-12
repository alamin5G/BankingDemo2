package com.goonok;

import java.util.HashMap;
import java.util.Set;

public class Bank {

    private HashMap<Integer, Integer> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextAcct = 0;

    public int newAccount(){
        int acctNum = nextAcct++;
        accounts.put(acctNum, 0);
        return acctNum;
    }


    public int getBalance(int acctnum){
        return accounts.get(acctnum);
    }

    public void deposit(int acctnum, int amt){
        int balance = accounts.get(acctnum);
        accounts.put(acctnum, balance+amt);

    }

    public boolean authorizeLoan(int acctnum, int loanamt){
        int balance = accounts.get(acctnum);
        return balance >= loanamt/2;
    }

    public String toString(){
        Set<Integer> accts = accounts.keySet();
        String result = "The Bank has " + accts.size() + " accounts";
        for ( int i : accts){
            result += "\n\tBank account " + i + ": balance= " + accounts.get(i);
        }
        return result;
    }

    public void addInterest(){
        Set<Integer> accts = accounts.keySet();
        for(int i : accts){
            int balance = accounts.get(i);
            int newBalance = (int) (balance * (1+rate));
            accounts.put(i, newBalance);
        }
    }

}