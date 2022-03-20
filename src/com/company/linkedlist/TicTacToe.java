package com.company.linkedlist;

import java.util.*;

public class TicTacToe {

    static List<Integer> playerPos = new ArrayList<>();
    static List<Integer> computerPos = new ArrayList<>();
    public static void main(String[] args) {
        char[][] board = {{' ','|', ' ','|',' '},{'-','+','-','+','-'},
                {' ','|', ' ','|',' '},{'-','+','-','+','-'},{' ','|', ' ','|',' '}};



        //Get user input
        boolean gameOver = false;
        int counter = 0;
        while( counter < 10){

            System.out.println();
            System.out.println("Enter -1 to cancel the game");
            System.out.print("Enter your game position: ");
            Scanner scanner = new Scanner(System.in);
            int pos = scanner.nextInt();
            while(playerPos.contains(pos) || computerPos.contains(pos)){
                System.out.print("Position "+ playerPos+ " && "+ computerPos+" taken!!,\n Please enter a new Position: " );
                pos = scanner.nextInt();
            }
            if(pos == -1){
//                gameOver = true;
                return;
            }
            System.out.println("My game pos ===> " + pos);
            playerPos.add(pos);
            playGame(pos,board,'X');
            System.out.println();
            printGameBoard(board);
            if(checkWinner(playerPos,computerPos)){
                System.out.println("GAME OVER!!");
                return;
            }
            System.out.print("Computers Turn...");
            int comPos = new Random().nextInt(9) + 1;
            while(playerPos.contains(comPos) || computerPos.contains(comPos)){
                System.out.print("\nPosition "+ playerPos+ " && "+ computerPos+ " taken!!,\n Please enter a new Position: " );
                comPos =  new Random().nextInt(9) + 1;
            }
            System.out.println("Computer Position: "+comPos);
            computerPos.add(comPos);
            playGame(comPos,board,'O');
            printGameBoard(board);
            if(checkWinner(playerPos,computerPos)){
                System.out.println("GAME OVER!!");
                return;
            }


        }
        System.out.println("Game ends in a draw");

    }



    static boolean checkWinner(List<Integer> playerPos,List<Integer> comPos){
        List<Integer> firstRow = Arrays.asList(1,2,3);
        List<Integer> secondRow = Arrays.asList(4,5,6);
        List<Integer> thirdRow = Arrays.asList(7,8,9);
        List<Integer> firstColumn = Arrays.asList(1,4,7);
        List<Integer> secondColumn = Arrays.asList(2,5,8);
        List<Integer> thirdColumn = Arrays.asList(3,6,9);
        List<Integer> rightDiagonal = Arrays.asList(1,5,9);
        List<Integer> leftDiagonal = Arrays.asList(3,5,7);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(firstRow);
        lists.add(secondRow);
        lists.add(thirdRow);
        lists.add(firstColumn);
        lists.add(secondColumn);
        lists.add(thirdColumn);
        lists.add(rightDiagonal);
        lists.add(leftDiagonal);
        for(List<Integer> winningPos : lists){
            if(playerPos.containsAll(winningPos)){
                System.out.println( "Player Wins");
                return true;
            } else if(comPos.containsAll(winningPos)) {
                System.out.println( "Computer Wins");
                return true;
            }
            else if(playerPos.size() + comPos.size() == 9){
                    System.out.println("Game Ends in a Draw");
                    return true;


            }

        }
        return false;
    }

    static void playGame(int pos,char[][] board,char c){
        switch(pos){
            case 1:
                board[0][0] = c;
                break;
            case 2:
                board[0][2] = c;
                break;
            case 3:
                board[0][4] = c;
                break;
            case 4:
                board[2][0] = c;
                break;
            case 5:
                board[2][2] = c;
                break;
            case 6:
                board[2][4] = c;
                break;
            case 7:
                board[4][0] = c;
                break;
            case 8:
                board[4][2] = c;
                break;
            case 9:
                board[4][4] = c;
                break;
            default:
                break;
        }
    }

    static void printGameBoard(char[][] board){
        for(char[] game : board){
            for(char c : game){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
