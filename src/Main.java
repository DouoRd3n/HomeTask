import Model.Human;
import Model.Man;
import Model.Woman;
import console.ConsoleReader;
import console.ConsoleWriter;
import dBase.DataBase;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        startMenu();
        choseAction();
    }

    private static void choseAction() throws IOException {
        DataBase dataBase = new DataBase();
        while (true) {
            print("Make your choise : ");
            String s = ConsoleReader.getInstanse().readString();
            if (s.equals("exit") || s.equals("3")) {
                break;
            } else {
                makeChoise(dataBase,s);
            }



        }
    }

    private static void makeChoise(DataBase dataBase, String s) throws IOException {

         if (s.equals("1") || s.equals("Add user")) {
            putSex(dataBase);



        } else if (s.equals("2") || s.equals("get user by id")) {
            putID(dataBase);


        } else if (s.equals("get oll DB") || s.equals("000")){
            getAllInformation(dataBase);
        }else {
            println("Wrong chose");
            startMenu();
        }
    }

    private static void putID(DataBase dataBase) throws IOException {
        print("Put id : ");
        String id = ConsoleReader.getInstanse().readString();
        getByIdDataBase(id, dataBase);
        println("");
    }

    private static void putSex(DataBase dataBase) throws IOException {
        print("Put sex : ");
        String sex = ConsoleReader.getInstanse().readString();
        println("");
        manOrWoman(sex, dataBase);
    }

    private static void manOrWoman(String sex, DataBase dataBase) throws IOException {
        if (sex.equals("woman")) {

            Human human = new Woman();
            print("Put name : ");
            human.setName(ConsoleReader.getInstanse().readString());
            putDataBase(human, dataBase);
            println("");
            print("Put second name : ");
            human.setSecondName(ConsoleReader.getInstanse().readString());
            println("");
            print("Put age : ");
            human.setAge(ConsoleReader.getInstanse().readInt());

        } else if (sex.equals("man")) {
            Human human = new Man();
            print("Put name : ");
            human.setName(ConsoleReader.getInstanse().readString());
            putDataBase(human, dataBase);
            println("");
            print("Put second name : ");
            human.setSecondName(ConsoleReader.getInstanse().readString());
            println("");
            print("Put age : ");
            human.setAge(ConsoleReader.getInstanse().readInt());
        }
    }

    private static void manOrWoman(String sex) {

    }

    private static void getAllInformation(DataBase dataBase) {
        Map<String, Human> humanMap = dataBase.getdBMemory();
        for (Map.Entry me : humanMap.entrySet()) {
          println(me.getValue().toString());
        }
    }

    private static void getByIdDataBase(String id, DataBase dataBase) {
        print(dataBase.getById(id).toString());

    }


    private static void putDataBase(Human human, DataBase dataBase) {
        dataBase.addHuman(human);
    }


    public static void println(String s) {
        ConsoleWriter writer = new ConsoleWriter();
        writer.writeLn(s);

    }
    public static void print(String s){
        ConsoleWriter writer = new ConsoleWriter();
        writer.write(s);
    }

    private static void startMenu() {
        println("Chose value");
        println("1 - Add user");
        println("2 - get user by id");
        println("3 - exit");
    }


}

