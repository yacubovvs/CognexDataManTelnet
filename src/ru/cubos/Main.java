package ru.cubos;

public class Main {

    public static void main(String[] args) {
        DataManTelnetClient dataManTelnetClient = new DataManTelnetClient(new DataManCollable(), "10.0.0.218", 1);
        dataManTelnetClient.start();
    }
}
