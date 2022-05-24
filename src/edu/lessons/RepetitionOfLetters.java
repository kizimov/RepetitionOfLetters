package edu.lessons;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class RepetitionOfLetters {
    // Дан текст(текстовый файл формата .txt)
    // Вернуть три наиболее часто встречающихся буквы
    // Заглавные и прописные буквы считаются одинаковыми

    public static void main(String[] args) throws IOException {
        // у тебя явно указан путь к файлу. А что делать если скачали с гита и там другое расположение. Укажи, что файл лежит в отдельной папке /src/resources
        //что будет делать программа если файла там не окажится. Можно чтоб она об єтом сообщила и попросила вручную ввести путь... 
        //Все єто должно проискодить в отдельном сервисе (классе). 
        String fileName = "C:\\Users\\IVAN\\IdeaProjects\\RepetitionOfLetters\\out\\production\\RepetitionOfLetters\\edu\\lessons\\text.txt";
        String contents = readUsingScanner(fileName);
        process(textFormat(contents));

    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName));
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }

    private static String textFormat(String textFormat) {
        String finText = textFormat.toLowerCase();
        finText = finText.replace(" ", "");
        finText = finText.replace("\n", ""); //переносы строки не удаляються
        return finText;
    }

    private static void process(String s) {
        //create a map with pairs <character, value>
        Map<Character, Integer> mapText = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!mapText.containsKey(s.charAt(i))) {
                mapText.put(s.charAt(i), 1);
            } else {
                mapText.put(s.charAt(i), mapText.get(s.charAt(i)) + 1);
            }
        }

        //output three maximum values in a cycle
        for (int i = 0; i < 3; i++) {
            int max = 0;
            char maxSymbol = ' ';
            for (Map.Entry<Character, Integer> entry : mapText.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxSymbol = entry.getKey();
                }
            }
            System.out.println("Symbol - "+maxSymbol+" Repeats - "+max);
            mapText.remove(maxSymbol);
        }
    }
}
