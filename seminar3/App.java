package seminar3;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        ParseData parseData = new ParseData();
        String newFileName = null;
        WriteFile writeFile = new WriteFile();

        HashMap<String, Object> data = parseData.parseInputData();
        while (data.size() != 6) {
            try {
                throw new DataException();
            } catch (DataException e) {
                data = parseData.parseInputData();
            }
        }
        newFileName = data.get("familyName") + ".txt";
        StringBuilder outData = new StringBuilder();
        outData.append(data.get("familyName"));
        outData.append(" ");
        outData.append(data.get("firstName"));
        outData.append(" ");
        outData.append(data.get("patronymic"));
        outData.append(" ");
        outData.append(data.get("date"));
        outData.append(" ");
        outData.append(data.get("tel"));
        outData.append(" ");
        outData.append(data.get("gender"));
        System.out.println(data);
        System.out.println(outData);
        String filePath = newFileName;
        writeFile.writeData(String.valueOf(outData), filePath);
    }
}
