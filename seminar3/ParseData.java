package seminar3;

import java.util.HashMap;

public class ParseData {

    public HashMap<String, Object> parseInputData() {
        InputData inputData = new InputData();
        String[] data = inputData.inputData();
        HashMap<String, Object> dataSave = new HashMap<>();
        StringBuilder fio = new StringBuilder();
        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("f") || i.equals("m")) {
                    dataSave.put("gender", i);
                } else{
                    try {
                        throw new GenderException();
                    }
                        catch (GenderException e) {
                        genderException(i);
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayDate = i.split("\\.");
                if (Integer.parseInt(arrayDate[0]) < 0 || Integer.parseInt(arrayDate[0]) > 31 ||
                    Integer.parseInt(arrayDate[1]) < 0 || Integer.parseInt(arrayDate[1]) > 12 ||
                    Integer.parseInt(arrayDate[2]) < 0 || Integer.parseInt(arrayDate[1]) > 2023) {
                    try {
                        throw new DataException();
                    } catch (DataException e) {
                        e.dataException(i);
                    }
                } else {
                    dataSave.put("date", i);
                    } 
            } else if (i.matches("[0-9]+")) {
                dataSave.put("tel", i);
            } else if (i.matches("[A-Za-z]+")) {
                fio.append(i + " ");
            } else {
                try {
                    throw new DataException();
                } catch (DataException e) {
                    e.dataException(i);
                }
            }
        }
        String[] fullName = String.valueOf(fio).split(" ");
        if (fullName.length == 3) {
            dataSave.put("firstName", fullName[1]);
            dataSave.put("familyName", fullName[0]);
            dataSave.put("patronymic", fullName[2]);
        }
        return dataSave;
    }

    private void genderException(String i) {
        System.out.println("Exception: GenderNotCorrectData");
        System.out.printf("It`s not correct data: %s", i);
        System.out.println();
    }
}
