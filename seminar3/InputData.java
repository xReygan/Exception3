package seminar3;

import java.util.Scanner;

public class InputData {
    public String[] inputData() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите Ф.И.O, дату рождения(dd.mm.yyyy), номер телефона (цифры), пол (f/m) через пробел:");
            String data = scanner.nextLine();
            String[] arrayData = data.split(" ");
            if (arrayData.length == 6) {
                return arrayData;
            } else if (arrayData.length < 6){
                System.out.println("you did not enter all the data, please try again");
            } else System.out.println("you have entered more data, please try again");
        }
    }
}
