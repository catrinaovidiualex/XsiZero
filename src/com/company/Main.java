package com.company;

import javax.lang.model.util.ElementScanner6;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.company.XsiZero.*;

public class Main {

    public static void main(String[] args) {

        char [][] gameBoard={
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}
        };


        //
        while (true) {
            Scanner citeste = new Scanner(System.in);
            System.out.println("Introduceti numarul casutei in care doriti sa puneti X (1-9):");
            int pozUser = citeste.nextInt();

            // verificam daca casuta aleasa nu este deja ocupata -> intrucat nu pot alege si eu si PC aceeasi casuta pt a plasa X sau O;

            while(userPositions.contains(pozUser) || pcPositions.contains(pozUser)){
                System.out.println("USER: aceasta casuta este ocupata, va rugam sa alegti o alta casuta goala!");
                pozUser=citeste.nextInt();
            }

            plaseazaXSauZero(gameBoard, pozUser, "user");

            // verificam rezultatul final sa vedem daca deja a castigat cineva, aceasta verificare se face dupa fiecare mutare (indiferent ca muta userul sau pc-ul)
            String rezultatFinal = verificareCastigator();

            if(rezultatFinal.length()>0){
                System.out.println(rezultatFinal);
                break;}

            // generez O-uri pentru PC
            Random randomPCValue = new Random();
            int pozitiePC = randomPCValue.nextInt(9) + 1; // pozitie random intre 1 si 9

            // verificam daca casuta este deja ocupata

            while(userPositions.contains(pozitiePC) || pcPositions.contains(pozitiePC)){
               pozitiePC=randomPCValue.nextInt(9) + 1;
            }

            plaseazaXSauZero(gameBoard, pozitiePC, "PC");

            displayGameBoard(gameBoard);

            // verificam rezultatul final sa vedem daca deja a castigat cineva, aceasta verificare se face dupa fiecare mutare (indiferent ca muta userul sau pc-ul)

            rezultatFinal = verificareCastigator();
            if(rezultatFinal.length()>0){
            System.out.println(rezultatFinal);
            break;}
        }

    }
}
