package com.example.tables;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class StudentsTable extends BaseTable {
    final String ERROR_SIZE = "Некорректные данные ученика. Ученик обязан иметь хотя бы ИМЯ и ФАМИЛИЮ.";
    String longestName = "Имя";
    String longestSurname = "Фамилия";
    String longestPatronymic = "Отчество";
    private int idGenerator = 1;
    ArrayList<Integer> id = new ArrayList<>();
    TreeMap<Integer, String> names = new TreeMap<>();
    TreeMap<Integer, String> surname = new TreeMap<>();
    TreeMap<Integer, String> patronymic = new TreeMap<>();


    @Override
    public void add(String person) {
        String[] cutLine = person.split(" ");
        if(cutLine.length < 2 && cutLine.length > 3) {
            System.out.println(ERROR_SIZE);
        }
        else {
            for(int x : names.keySet()) {
                if((cutLine.length == 2) && surname.get(x).equals(cutLine[0]) && names.get(x).equals(cutLine[1]) ) {
                    System.out.println("Ученик с таким именем и фамилией уже существует");
                    return;
                }
                else if((cutLine.length == 3) && surname.get(x).equals(cutLine[0]) && names.get(x).equals(cutLine[1]) && patronymic.get(x).equals(cutLine[2])) {
                    System.out.println("Ученик с таким именем, фамилией и отчеством уже существует");
                    return;
                }
            }
            try {
                id.add(idGenerator++);
                surname.put(idGenerator-1, cutLine[0]);
                if(longestSurname.length() < cutLine[0].length()) longestSurname = cutLine[0];
                names.put(idGenerator-1, cutLine[1]);
                if(longestName.length() < cutLine[1].length()) longestName = cutLine[1];
                patronymic.put(idGenerator-1, cutLine[2]);
                if(longestPatronymic.length() < cutLine[2].length()) longestPatronymic = cutLine[2];
            }
            catch (IndexOutOfBoundsException e) {
                patronymic.put(idGenerator-1, "null");
            }
        }


    }
    @Override
    public void print() {
        int idRep = Math.max(String.valueOf(idGenerator).length(), 2) - 2;
        int nameRep = longestName.length() - 3;
        int surRep = longestSurname.length() - 7;
        int patRep = longestPatronymic.length() - 8;
        StringBuilder titleLine = new StringBuilder();
        titleLine.append("Id" + " ".repeat(idRep) + "|").append("Имя" + " ".repeat(nameRep) + " |").append("Фамилия" + " ".repeat(surRep) + " |").append("Отчество" + " ".repeat(patRep) + " |");
        System.out.println(titleLine);Е
        System.out.println("-".repeat(titleLine.length()));
        for(int i : id) {;
            System.out.print(i + " ".repeat(Math.abs(String.valueOf(idGenerator < 10 ? idGenerator + " " : idGenerator).length() - String.valueOf(i).length())) +"|");
            System.out.print(names.get(i) + " ".repeat(Math.abs(longestName.length()- names.get(i).length()))  + " |");
            System.out.print(surname.get(i) + " ".repeat(Math.abs(longestSurname.length() - surname.get(i).length())) + " |");
            System.out.println(patronymic.get(i) + " ".repeat(Math.abs(longestPatronymic.length() - patronymic.get(i).length())) + " |");
        }
    }
}
