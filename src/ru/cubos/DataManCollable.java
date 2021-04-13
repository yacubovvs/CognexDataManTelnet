package ru.cubos;

public class DataManCollable implements DataManCallback {
    @Override
    public void onCodeScanned(String codeString) {
        System.out.println("Code scanned " + codeString);
    }
}
