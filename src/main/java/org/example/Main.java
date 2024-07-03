package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.tools.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    public static void main(String[] args) {
//        String a = "{\"MSSV\":\"21207222\",\"countString\":\"1\",\"orderString\":\"1\",\"stringText\":\"111  Hello   111\"}";

//        int indexMSSV = a.indexOf("MSSV");
//        int indexCountString = a.indexOf("countString");
//        int indexOrderString = a.indexOf("orderString");
//        int indexStringText = a.indexOf("stringText");
//
//
//        String MSSV = a.substring(indexMSSV + 7, indexCountString - 3);
//        String countString = a.substring(indexCountString + 14, indexOrderString - 3);
//        String orderString = a.substring(indexOrderString + 14, indexStringText - 3);
//        String stringText = a.substring(indexStringText + 13, a.length() - 2);

//        System.out.println(a);
//        System.out.println(stringText);
//        System.out.println(orderString);
//        System.out.println(countString);
//        System.out.println(MSSV);



























        SpringApplication.run(Main.class, args);
//        Function function = new Function();
//        ArrayList<String> arrayList = new ArrayList<>();
//        String a = function.extractStringText("[{\"MSSV\":\"21207222\",\"countString\":\"1\",\"orderString\":\"1\",\"stringText\":\" public void mergeAndDeleteFile(String countString, String MSSV){\n" +
//                "        String data = \"\";\n" +
//                "        for(int i = 1; i <= Integer.parseInt(countString); i++){\n" +
//                "            String name = \"orderFile\" + Integer.toString(i);\n" +
//                "            data = readFile(MSSV, name);\n" +
//                "            writeFileMerge(MSSV,\"orderFile\", data);\n" +
//                "            System.out.println(\"Gop file thanh cong. \");\n" +
//                "        }\n" +
//                "        for(int i = 1; i <= Integer.parseInt(countString); i++){\n" +
//                "            String name = \"orderFile\" + Integer.toString(i);\n" +
//                "            deleteFile(MSSV, name);\n" +
//                "        }\n" +
//                "    } \"}]");
//
//        System.out.println(a);

//        for (String a : arrayList){
//            System.out.println(a);
//        }


//        String code = "import java.io.*;\n" +
//                "\n" +
//                "public class FileIO {\n" +
//                "    public static void main(String[] args) {\n" +
//                "        // Đọc file\n" +
//                "        readFile();\n" +
//                "\n" +
//                "        // Ghi file\n" +
//                "        writeFile();\n" +
//                "    }\n" +
//                "\n" +
//                "    public static void readFile() {\n" +
//                "        try {\n" +
//                "            // Mở file để đọc\n" +
//                "            File file = new File(\"input.txt\");\n" +
//                "            File file = new File(\"input.txt\");\n" +
//                "            File file = new File(\"input.txt\");\n" +
//                "            FileReader fileReader = new FileReader(file);\n" +
//                "            BufferedReader bufferedReader = new BufferedReader(fileReader);\n" +
//                "\n" +
//                "            String line;\n" +
//                "            System.out.println(\"Đọc từ file:\");\n" +
//                "            while ((line = bufferedReader.readLine()) != null) {\n" +
//                "                System.out.println(line);\n" +
//                "            }\n" +
//                "\n" +
//                "            // Đóng file\n" +
//                "            bufferedReader.close();\n" +
//                "            fileReader.close();\n" +
//                "        } catch (IOException e) {\n" +
//                "            System.out.println(\"Lỗi khi đọc file: \" + e.getMessage());\n" +
//                "        }\n" +
//                "    }";
//
//        String folder = "21207192";
//        String modifiedCode = modifyFilePathsInCode(folder, code);
//
//        System.out.println(modifiedCode);
//
//
//        System.out.println("-------------------------------------------------- Test doi duong dan");

//        String code = "public static void writeCodeToFile(String code) {\n" +
//                "        String filePath = \"File.csv\";\n" +
//                "        String anotherPath = \"AnotherFile.txt\";\n" +
//                "        String yetAnotherPath = \"YetAnotherFile.txt\";\n" +
//                "        String testPath = \"TestFile.doc\";\n" +
//                "\n" +
//                "        try (FileWriter writer = new FileWriter(filePath)) {\n" +
//                "            writer.write(code);\n" +
//                "            System.out.println(\"Code has been written to \" + filePath);\n" +
//                "        } catch (IOException e) {\n" +
//                "            System.out.println(\"An error occurred while writing the code to file.\");\n" +
//                "            e.printStackTrace();\n" +
//                "        }\n" +
//                "    }";

//        String code = "import java.io.*;\n" +
//                "\n" +
//                "public class FileIO {\n" +
//                "    public static void main(String[] args) {\n" +
//                "        // Đọc file\n" +
//                "        readFile();\n" +
//                "    }\n" +
//                "\n" +
//                "    public static void readFile() {\n" +
//                "        try {\n" +
//                "            // Mở file để đọc\n" +
//                "            File file = new File(\"input.txt\");\n" +
//                "            FileReader fileReader = new FileReader(file);\n" +
//                "            BufferedReader bufferedReader = new BufferedReader(fileReader);\n" +
//                "\n" +
//                "            String line;\n" +
//                "            System.out.println(\"Đọc từ file:\");\n" +
//                "            while ((line = bufferedReader.readLine()) != null) {\n" +
//                "                System.out.println(line);\n" +
//                "            }\n" +
//                "\n" +
//                "            // Đóng file\n" +
//                "            bufferedReader.close();\n" +
//                "            fileReader.close();\n" +
//                "        } catch (IOException e) {\n" +
//                "            System.out.println(\"Lỗi khi đọc file: \" + e.getMessage());\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//
//        String folder = "NewFolder";
//        // Gọi phương thức để chỉnh sửa đường dẫn trong code
//        String modifiedCode = modifyFilePathsInCode(folder, code);
//
//        // In ra đoạn code đã chỉnh sửa
//        System.out.println(modifiedCode);
//
//
//        // Thí dụ sử dụng phương thức generateClass
//        String importStatement = "import java.util.*;";
//        String className = "MyGeneratedClass";
//        String methodName = "myMethod";
//        String param = "This is a test";
//
//        String generatedClass = generateClass(importStatement, className, methodName, param);
//        System.out.println(generatedClass);


//        String filePath = "C:\\Users\\Tan Phong\\IdeaProjects\\JavaComplier_New\\src\\main\\java\\org\\example\\SaveStringToFile.java";
//        String methodName = "save";
//
//        ArrayList<String> parameters = findMethodParameters(filePath, methodName);
//        if (parameters.isEmpty()) {
//            System.out.println("Method not found or method has no parameters.");
//        } else {
//            System.out.println("Parameter types:");
//            for (String type : parameters) {
//                System.out.println(type);
//            }
//        }
//        System.out.println("-----------------------------------------------------Tim file theo path truyen vao vao tra ve kdl");
//
//        String sourceCode = "public class SumNumbers {\n" +
//                "    public static void main(String[] args) {\n" +
//                "        // Khai báo biến để lưu trữ tổng\n" +
//                "        int sum = 0;\n" +
//                "\n" +
//                "        // Vòng lặp for để tính tổng các số từ 1 đến 10\n" +
//                "        for (int i = 1; i <= 10; i++) {\n" +
//                "            // Thêm giá trị của i vào biến sum\n" +
//                "            sum += i;\n" +
//                "        }\n" +
//                "\n" +
//                "        // In ra tổng của các số từ 1 đến 10\n" +
//                "        System.out.println(\"Tổng của các số từ 1 đến 10 là: \" + sum);\n" +
//                "    }\n" +
//                "}";
//
//        ArrayList<String> arrayList = tim_dau_gach_cheo(sourceCode, true);
//        for (String value : arrayList) {
//            System.out.println(value);
//        }

//        Controller controller = new Controller();
//        System.out.println(controller.receiveCode());

//        Function function = new Function();
//        System.out.println(function.readFileContent("21207196", "Assignment 2"));

    }
}
