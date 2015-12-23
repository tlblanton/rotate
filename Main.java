import java.util.*;
import static java.lang.System.out;
import java.io.*;

class Functions
{
    void printBoard(ArrayList<Character> board, int N)
    {
        int count = 0;
        for(int i = 0; i < N*N; ++i)
        {
            out.print(board.get(i));
            count++;
            if(count == N)
            {
                out.print('\n');
                count = 0;
            }
        }
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
            func.printBoard(board, N);
            out.println();

        }
    }
}
