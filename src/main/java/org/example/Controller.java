package org.example;

import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.PSource;
import java.io.File;

// 3330: Thanh cong
// 3333: Loi data

@RestController
public class Controller {
    private Function function = new Function();
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    // https://javaserver.neosoft.vn/testcases/submitCode
    @PostMapping("/submitCode")
    public String receiveCode(@RequestParam("mssv") String MSSV,
                              @RequestParam("countstring") String countString,
                              @RequestParam("orderstring") String orderString,
                              @RequestParam("filename") String fileName,
                              @RequestParam("filetype") String fileType,
                              @RequestBody String sourceCode) {
//        String sourceCode1 = "{\"MSSV\":\"haha\",\"countString\":\"1\",\"orderString\":\"1\",\"sourceCode\":\"Apublic void mergeAndDeleteFile(String countString, String MSSV){\n" +
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
//                "    }\"}";

        // ------------------------------


//
//        int indexMSSV = sourceCode1.indexOf("MSSV");
//        int indexCountString = sourceCode1.indexOf("countString");
//        int indexOrderString = sourceCode1.indexOf("orderString");
//        int indexsourceCode = sourceCode1.indexOf("sourceCode");
//
//        String MSSV = sourceCode1.substring(indexMSSV + 7, indexCountString - 3);
//        String countString = sourceCode1.substring(indexCountString + 14, indexOrderString - 3);     // 2
//        String orderString = sourceCode1.substring(indexOrderString + 14, indexsourceCode - 3);      // 1
//        String sourceCode = sourceCode1.substring(indexsourceCode + 13, sourceCode1.length() - 2);

//        boolean status = Integer.parseInt(countString) == Integer.parseInt(countString);
        
        // ---------------------------------------
//
//        if (MSSV.equals("Error") || countString.equals("Error") || orderString.equals("Error") || sourceCode.equals("Error")){
//            return "3333";
//        }

        try {
            if (Integer.parseInt(orderString) > Integer.parseInt(countString)){
                return "3333";
            }

            String startNamePath = New.path + MSSV;
            File folder = new File(startNamePath);

            if (!function.checkFolderExists(folder)){
                function.createFolder(MSSV, startNamePath);
            }

//            String filePath = New.path + MSSV + "/orderFile.java";
//            File file = new File(filePath);

//            boolean checkExist = function.checkFileExists(file);
//            if (checkExist){
//                return "3333";
//            }

            function.writeFile(MSSV, fileName + orderString, sourceCode, fileType);
//            if (checkCondition == 0){
//                return "3333";
//            }

            int countFile = function.searchFile(startNamePath);
            if (countFile == 0){
                return "3333";
            }

            if (Integer.parseInt(countString) == Integer.parseInt(orderString)){  // 5
                function.mergeAndDeleteFile(countString, MSSV, fileName, fileType);
            }

        } catch (Exception e){
            return "3333";
        }
        return "3330";
    }

    @GetMapping("/readFile")
    public String readFile (@RequestParam("folder") String folderName, @RequestParam("fileName") String nameFile, @RequestParam("fileType") String fileType){
        return function.readFile(folderName, nameFile, fileType);
    }
}

