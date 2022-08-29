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
            String data = "";
            while ((i = in.read()) != -1){
                data += (char) i;
            }
            String[] splitted = data.split("\n");
            name = splitted[0].split(": ")[1].replaceAll("\r", "");
            age = Integer.parseInt(splitted[1].split(": ")[1].replaceAll("\r", ""));
            email = splitted[2].split(": ")[1].replaceAll("\r", "");
            phone = Long.parseLong(splitted[3].split(": ")[1].replaceAll("\r", ""));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name,age, email, phone);
    }
}
