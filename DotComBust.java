import java.util.*;
public class DotComBust {
        //объявляем переменные
        private GameHelper helper=new GameHelper();
        private ArrayList<DotCom> dotComList=new ArrayList<DotCom>();//список который хранит наши сайты
        private int numOfGuess=0;
        //объявляем методы
    private void setUpGame(){//cоздает объекты DotCom, присваивает им имена и адреса, выводит инструкции пользователю.
        DotCom one=new DotCom();
        one.setName("lms.synergy.ru");
        DotCom two=new DotCom();
        two.setName("Yandex.ru");
        DotCom three=new DotCom();
        three.setName("Aliexpress.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);
        System.out.println("Ваша цель - потопить три сайта.");
        System.out.println("Google.com,Yandex.ru,Aliexpress.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");
        for(DotCom dotComToSet: dotComList){
            ArrayList<String> newLocation=helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while(!dotComList.isEmpty()){
            String userGuess= helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    public void checkUserGuess(String userGuess){
        numOfGuess++;
        String result="Мимо";
        for(DotCom dotComToTest: dotComList){
            result=dotComToTest.checkYourSelf(userGuess);
            if(result.equals("Попал")){
                break;
            }
            if(result.equals("Потопил")){
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    public void finishGame(){
        System.out.println("Все ваши сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if(numOfGuess<=18){
            System.out.println("Это заняло у вас всего "+numOfGuess+" попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        }else{
            System.out.println("Это заняло у вас довольно много времени. "+ numOfGuess+" попыток");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }

    public static void main(String[] args) {
        DotComBust game=new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
//Ходить надо типа a1 b1 c1 d1 e1 f1
//И нарисуйте на листике сетку чтоб играть легче было