package ru.abovyan.git.backend;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileWork {
    private static String filePath = "C:\\Users\\rabov\\OneDrive\\Рабочий стол\\" +
            "labs\\МР\\git\\src\\main\\resources";
    private static String fileName = "data.txt";
    private File file;


    public FileWork() throws IOException {
        this.file = new File(filePath, fileName);
    }

    public void writeLine(String line) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(line + "\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }

    public String output() {
        String result = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                result = result.concat(line + "\n");
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Возникла ошибка во время чтения, проверьте данные.");
        }
        return result;
    }
}
