package main.java;

public class SnakesLadders {

    int player1 = 0;
    int player2 = 0;
    int nextPlayer = 1;

    public SnakesLadders() {
    }

    public String play(int die1, int die2) {
        if (player1 == 100 || player2 == 100) {
            return "Game over!";
        }
        int newPos = (nextPlayer == 1 ? player1 : player2) + die1 + die2;
        if (newPos == 100) {
            if (nextPlayer == 1) {
                player1 = 100;
            } else {
                player2 = 100;
            }
            return "Player " + nextPlayer + " Wins!";
        } else if (newPos > 100) {
            newPos = 200 - newPos;
        }
        switch (newPos) {
            case 2:
                newPos = 38;
                break;
            case 7:
                newPos = 14;
                break;
            case 8:
                newPos = 31;
                break;
            case 15:
                newPos = 26;
                break;
            case 16:
                newPos = 6;
                break;
            case 21:
                newPos = 42;
                break;
            case 28:
                newPos = 84;
                break;
            case 36:
                newPos = 44;
                break;
            case 46:
                newPos = 25;
                break;
            case 49:
                newPos = 11;
                break;
            case 51:
                newPos = 67;
                break;
            case 62:
                newPos = 19;
                break;
            case 64:
                newPos = 60;
                break;
            case 71:
                newPos = 91;
                break;
            case 74:
                newPos = 53;
                break;
            case 78:
                newPos = 98;
                break;
            case 87:
                newPos = 94;
                break;
            case 89:
                newPos = 68;
                break;
            case 92:
                newPos = 88;
                break;
            case 95:
                newPos = 75;
                break;
            case 99:
                newPos = 80;
                break;
        }
        String message = "Player " + nextPlayer + " is on square " + newPos;
        if (nextPlayer == 1) {
            player1 = newPos;
        } else {
            player2 = newPos;
        }
        if (die1 != die2) {
            nextPlayer = nextPlayer == 1 ? 2 : 1;
        }
        return message;
    }

    public static void main(String[] args) {
        SnakesLadders game = new SnakesLadders();
        System.out.println(game.play(1, 1));
        System.out.println(game.play(1, 5));
        System.out.println(game.play(6, 2));
        System.out.println(game.play(1, 1));
    }
}
