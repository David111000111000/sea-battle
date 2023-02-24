import java.util.*;
public class DotCom {
    //Поля нашего класса
    private ArrayList<String> locationCells;//Список индексов в которые пользователь должен будет попасть
    private String name;
    private int numOfHits=0;//Число попаданий. Пон?
    //Методы нашего класса


    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourSelf(String stringGuess){
        String result="Мимо";
        int index=locationCells.indexOf(stringGuess);
        if(index>=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result="Потопил";
                System.out.println("Ой! Вы потопили "+name+" : (");
            }else{
                result="Попал";
        }
    }
        return result;//Метод проверки хода
}
}
//ХОДИТЬ НАДО ТИПА a1 c1

