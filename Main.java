import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;
import java.io.*;

class Functions
{
    void printBoard(ArrayList<Character> board, int N)
    {
        out.println("--------------------------------------------------");
        int count = 0;
        for(int i = 0; i < N*N; ++i)
        {
            out.print(board.get(i) + " ");
            count++;
            if(count == N)
            {
                out.print('\n');
                count = 0;
            }
        }
        out.println("--------------------------------------------------");
    }

    //ROTATE
    ArrayList<Character> rotate(ArrayList<Character> board, int N) //this rotates the board clockwise
    {
        ArrayList<Character> boardCopy = new ArrayList<>();

        int count = 0;
        int countdown = N-1;
        for(int i = 0; i < N*N; ++i)
        {
            boardCopy.add(board.get(N * countdown + count));
            countdown--;
            if (countdown == -1)
            {
                countdown = N - 1;
            }
            if (((i % (N - 1)) == 0) && i != 0)
            {
                count++;
            }
        }
        return boardCopy;
    }

    ArrayList<Character> gravity(ArrayList<Character> board, int N)
    {
        ArrayList<Character> gravBoard = new ArrayList<>(board);
        for(int j = 0; j < N; ++j)
        {
            for (int i = (N * N) - (N + 1); i >= 0; --i)//the cryptic "int i = (N*N)-(N+1)" makes sure that we start on the index of the last thing on the next-to-last row of the grid
            {
                if (gravBoard.get(i + N) == '.')
                {
                    gravBoard.set(i + N, gravBoard.get(i));
                    gravBoard.set(i, '.');
                }


            }
        }
        //printBoard(gravBoard, N);

        try
        {
            Thread.sleep(0);
        } catch (InterruptedException e)
        {
            out.println("Sleep interrupted early");
        }


        return gravBoard;
    }
}



public class Main
{
    public static void main(String[] args)throws FileNotFoundException
    {
        Functions func = new Functions();
        File f = new File("rotate_cases_small.txt");
        Scanner s = new Scanner(f);

        int numOfCases = s.nextInt();
        s.nextLine();                   //consuming the EOL character after numOfCases

        for (int i = 0; i < numOfCases; ++i)
        {
            int N, K;
            String temp = s.nextLine();
            N = Character.getNumericValue(temp.charAt(0));
            K = Character.getNumericValue(temp.charAt(2));

            ArrayList<Character> board = new ArrayList<>();

            for(int j = 0; j < N; ++j)
            {
                String tempLine = s.nextLine();
                for(int b = 0; b < N; ++b)
                {
                    board.add(tempLine.charAt(b));
                }
            }

            ArrayList<Character> rotatedBoard = new ArrayList<>(func.rotate(board, N));
            ArrayList<Character> gravBoard = new ArrayList<>(func.gravity(rotatedBoard, N));

            out.println("ORIGINAL");
            func.printBoard(board, N);
            out.println("ROTATED");
            func.printBoard(rotatedBoard, N);
            out.println("ROTATED + GRAVITY");
            func.printBoard(gravBoard, N);
           try
           {
               in.read();
           }catch(Exception e)
           {}

            out.println("\n\n\n\n\n\n\n\n\n");

        }
    }
}
