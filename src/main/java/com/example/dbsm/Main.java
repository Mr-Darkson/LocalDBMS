package com.example.dbsm;


import com.example.tables.BaseTable;
import com.example.tables.StudentsTable;
import com.example.tables.TestingTable;
import com.example.tables.VariantsTable;
import eu.hansolo.tilesfx.addons.Switch;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static StudentsTable studentsTable = new StudentsTable();
    public static TestingTable testingTable = new TestingTable();
    public static VariantsTable variantsTable = new VariantsTable();
    private static BaseTable selectedTable;
    public static void main(String[] args) {


        try(Scanner console = new Scanner(System.in)) {
            while(true) {
                if (selectedTable == null) {
                    System.out.println("Please, SELECT the table: Students, Testing, Variants\nWrite the command:");
                    selectedTable = selectCommand(console.nextLine());
                    if (selectedTable == null) continue;
                }

                String[] command = console.nextLine().replaceAll("\"", "").split(" ");
                switch (command[0].toLowerCase()) {
                    case "add":
                        if (selectedTable == studentsTable) {
                            if (command.length < 3 ||  command.length > 5) {
                                System.out.println("Error enter student");
                                break;
                            } else {
                                String stapled = "";
                                for (int i = 1; i < command.length; i++) {
                                    stapled += command[i] + " ";
                                }
                                selectedTable.add(stapled);
                            }
                        }
                        break;
                    case "print":
                        selectedTable.print();
                        break;
                }
            }
         }

    }

    private static BaseTable selectCommand(String command) {
        String[] line = command.split(" ");
        if(line.length != 2) {
            System.out.println("You need write \"SELECT\" to choose table\n");
        }
        if("Select".equals(line[0])) {
            switch (line[1].toLowerCase()) {
                case "students":
                    System.out.println("Table \"Students\" selected");
                    return studentsTable;
                case "testing":
                    System.out.println("Table \"Testing\" selected");
                    return testingTable;
                case "variants":
                    System.out.println("Table \"Variants\" selected");
                    return variantsTable;
                default:
                    System.out.println("The table \"" + line[1] + "\" not found");
                    return null;
            }
        }
        else {
            return null;
        }
    }
}
