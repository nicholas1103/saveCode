package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;


public class Function {
    SQLData sqlData = new SQLData();
    boolean createFolder(String MSSV, String folderName){    // xong
        File file = new File(folderName);
        if (file.mkdirs()) {
            sqlData.insertData(MSSV, folderName);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkFolderExists(File folder) {
        return folder.exists() && folder.isDirectory();
    }

    public void writeFile(String folderName, String fileName, String stringText, String fileType) {
        String file = New.path + folderName + "/" + fileName + "." + fileType;
        System.out.println("----------------------------");
        System.out.println(stringText);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(stringText);
        } catch (IOException e) {

        }
    }



    public int searchFile(String folderPath) {
        File directory = new File(folderPath);
        if (!directory.exists()) {
            return 0;
        }

        if (!directory.isDirectory()) {
            return 0;
        }
        int numberOfFiles = 0;
        for (File element : directory.listFiles()) {
            if(element.isDirectory()) {
                numberOfFiles += searchFile(element.getAbsolutePath());
            } else {
                numberOfFiles++;
            }
        }
        return numberOfFiles;
    }

    public String readFile(String folderName,String fileName, String fileType){
        String filePath= New.path + folderName + "/" + fileName + "." + fileType;
        String data = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data = data + '\n' + line;
            }
        } catch (IOException e) {

        }
        System.out.println("Data: " + data);
        return data;
    }

    void writeFileMerge(String folderName, String fileName, String stringText, String fileType){
        String file = New.path + folderName + "/" + fileName + "." + fileType;
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.write(stringText);
            System.out.println("Write File Merge: " + stringText);
        } catch (Exception ex) {

        }
    }

    public String deleteFile(String folderName, String fileName, String fileType){        // xonmg
        String filePath = New.path + folderName + "/" + fileName + "." + fileType;
        File file = new File(filePath);

        if(file.delete()){
            return "1";
        }
        else {
            return "0";
        }
    }

    public void mergeAndDeleteFile(String countString, String MSSV, String fileName, String fileType){
        String data = "";
        for(int i = 1; i <= Integer.parseInt(countString); i++){
            String name = fileName + Integer.toString(i);
            data = readFile(MSSV, name, fileType);
            writeFileMerge(MSSV, fileName, data, fileType);
            System.out.println("Gop file thanh cong. ");
        }
        for(int i = 1; i <= Integer.parseInt(countString); i++){
            String name = fileName + Integer.toString(i);
            deleteFile(MSSV, name, fileType);
        }
    }




    // -------------------------------------------------------------------------------------------


    private String formatFilePath(String originalPath) {
        String formattedPath = originalPath.replace("\\", "\\\\");
        return formattedPath;
    }

    public String findValues(String inputData, String findString){
        String data = "[" + inputData + "]";
        System.out.println(data);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Describe>>() {}.getType();
        ArrayList<Describe> assignmentArrayList = new ArrayList<>();
        try {
            assignmentArrayList = gson.fromJson(data, listType);

            for (Describe a : assignmentArrayList){
                System.out.println(a);
            }

            for (Describe describe : assignmentArrayList){
                if (findString.equals("sessionID")){
                    return describe.getSessionID();
                }
                if (findString.equals("MSSV")){
                    return describe.getMSSV();
                }
                if (findString.equals("exerciseTopic")){
                    return describe.getExerciseTopic();
                }
                if (findString.equals("countString")){
                    return describe.getCountString();
                }
                if (findString.equals("orderString")){
                    return describe.getOrderString();
                }
                if (findString.equals("stringText")){
                    return describe.getStringText();
                }
                if (findString.equals("typeFile")){
                    return describe.getTypeFile();
                }
                if (findString.equals("nameFile")){
                    return describe.getNameFile();
                }
            }
        } catch (Exception e){

        }
        return "Error";
    }

    public String readFileContent(String MSSV, String nameFile, String typeFile) {
        String baseDir = New.path;
        String filePath = baseDir + '/' + MSSV + '/' + nameFile + "." + typeFile;
        File file = new File(filePath);
        StringBuilder content = new StringBuilder();

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "Error reading file: " + e.getMessage();
            }
        } else {
            return "File does not exist.";
        }

        return content.toString();
    }

    public boolean writeToFileAndSavePath(String MSSV, String nameFile, String stringText, String typeFile, String countString, String orderString) {
        String baseDir = New.path;
        String folderPath = baseDir + '/' + MSSV;
        String filePath = folderPath + '/' + nameFile + "." + typeFile;   // /tomcat11/webapps/checkcases/MSSV/nameFile.java
        File file = new File(filePath);

        try {
            File directory = new File(folderPath);
            if (!directory.exists()) {
                directory.mkdirs();
//                sqlData.insertData(MSSV, formatFilePath(filePath));
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(file, false))) {
                writer.write(stringText);
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
