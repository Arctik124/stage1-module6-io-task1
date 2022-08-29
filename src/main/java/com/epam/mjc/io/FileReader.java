package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public  Profile getDataFromFile(File file) {
        String name = "";
        int age = 9;
        String email = "";
        long phone = 0;

        try (FileInputStream in = new FileInputStream(file.getAbsolutePath()) ){
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            while ((i = in.read()) != -1){
                stringBuilder.append((char) i);
            }

            String[] splitted = stringBuilder.toString().split("\n");
            name = splitted[0].split(": ")[1].replace("\r", "");
            age = Integer.parseInt(splitted[1].split(": ")[1].replace("\r", ""));
            email = splitted[2].split(": ")[1].replace("\r", "");
            phone = Long.parseLong(splitted[3].split(": ")[1].replace("\r", ""));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name,age, email, phone);
    }
}
