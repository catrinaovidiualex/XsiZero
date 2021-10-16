package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class XsiZero {
    public static ArrayList<Integer> userPositions = new ArrayList<Integer>();
    public static ArrayList<Integer> pcPositions = new ArrayList<Integer>();

public static void displayGameBoard(char [][] gameBoard){
    for(char[] row : gameBoard){
        for(char c : row){
            System.out.print(c);
        }
        System.out.println();
    }
}
public static void plaseazaXSauZero(char [][] gameBoard, int poz, String utilizator){
    char simbol=' ';
    if(utilizator.equals("user")){
        simbol='X';
        userPositions.add(poz);
            } else if (utilizator.equals("PC")){
        simbol='O';
        pcPositions.add(poz);
    };

    switch(poz){
        case 1:
            gameBoard[0][0]=simbol;
            break;
        case 2:
            gameBoard[0][2]=simbol;
            break;
        case 3:
            gameBoard[0][4]=simbol;
            break;
        case 4:
            gameBoard[2][0]=simbol;
            break;
        case 5:
            gameBoard[2][2]=simbol;
            break;
        case 6:
            gameBoard[2][4]=simbol;
            break;
        case 7:
            gameBoard[4][0]=simbol;
            break;
        case 8:
            gameBoard[4][2]=simbol;
            break;
        case 9:
            gameBoard[4][4]=simbol;
            break;
        default:
            break;
    }


}
public static String verificareCastigator(){

    List topRow= Arrays.asList(1,2,3); // valorile de pe primul rand;
    List midRow=Arrays.asList(4,5,6);// valorie de pe randul din mijloc;
    List botRow=Arrays.asList(7,8,9); // valorile de pe rultimul rand;

    List firstCol=Arrays.asList(1,4,7);// valorile de pe prima coloana
    List midCol=Arrays.asList(2,5,8);// valorile de pe coloana din mijloc
    List lastCol= Arrays.asList(3,6,9);// valorile de pe ultima coloana

    List diagonala1=Arrays.asList(1,5,9);//prima diagonala
    List diagonala2=Arrays.asList(7,5,3);//prima diagonala

    // trebuie adaugate listele cu liniile si coloanele intr-o alta lista => va rezulta o lista cu alte liste

    List<List> winningConditions = new ArrayList<List>();

    // adaugam listele in lista nou creata

    winningConditions.add(topRow);
    winningConditions.add(midRow);
    winningConditions.add(botRow);

    winningConditions.add(firstCol);
    winningConditions.add(midCol);
    winningConditions.add(lastCol);

    winningConditions.add(diagonala1);
    winningConditions.add(diagonala2);

    // parcurgem lista cu cele 8 liste;

    for(List l : winningConditions){

        if(userPositions.containsAll(l)){
            return "USER: Ai castigat!";

        } else if(pcPositions.containsAll(l)) { return "PC: Ai castigat!";}

        // verific daca s-a umplut tabla si nu exista castigator

        else if(userPositions.size()+pcPositions.size()==9){return "Mai incearca!";}

    }
    return "";




}

}

