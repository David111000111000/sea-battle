
import java.io.*;
import java.util.*;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;


    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + "  ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 )  return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }



    public ArrayList<String> placeDotCom(int comSize) {                 // line 19
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String [comSize];      // держит координаты
        String temp = null;                                // важная строчка!
        int [] coords = new int[comSize];                  // тут наши координаты
        int attempts = 0;                                  // счетчик попыток
        boolean success = false;                           // фложок))
        int location = 0;                                  // локация

        comCount++;
        int incr = 1;                                      // увеличение по горизонтали
        if ((comCount % 2) == 1) {                         // если нечетное - вертикально
            incr = gridLength;                               // увеличение по вертикали
        }

        while ( !success & attempts++ < 200 ) {             // поиск
            location = (int) (Math.random() * gridSize);      // рандомная точка старта
            //System.out.print(" try " + location);
            int x = 0;                                        // позиция для расположения
            success = true;                                 // успех
            while (success && x < comSize) {                // не использованные точки
                if (grid[location] == 0) {                    // если еще не использовано
                    coords[x++] = location;                    // точка сохранения
                    location += incr;                          // попробуй следующий)
                    if (location >= gridSize){                 // выходит за рамки
                        success = false;                         // неудача
                    }
                    if (x>0 & (location % gridLength == 0)) {  // выходит за рамки
                        success = false;                         // неудача
                    }
                } else {                                      // нашли уже используемую локацию
                    // System.out.print(" used " + location);
                    success = false;                          // неудача
                }
            }
        }                                                   // конец

        int x = 0;                                          // превращает "хорошую локацию" в альфа координаты
        int row = 0;
        int column = 0;
        // System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;                              // отмечает как использованную
            row = (int) (coords[x] / gridLength);             // получает значение raw
            column = coords[x] % gridLength;                  // получает значение колонки
            temp = String.valueOf(alphabet.charAt(column));   // конвертирует в альфа

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

             System.out.println("  coord "+x+" = " + alphaCells.get(x-1)); //ЧИТЫ НА БРАВЛ СТАРС

        }
        // System.out.println("\n"); ЧИТЫ НА БРАВЛ СТАРС

        return alphaCells;
    }
}