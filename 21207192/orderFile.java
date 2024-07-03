
{"MSSV":"haha","countString":"1","orderString":"1","sourceCode":"Apublic void mergeAndDeleteFile(String countString, String MSSV){
        String data = "";
        for(int i = 1; i <= Integer.parseInt(countString); i++){
            String name = "orderFile" + Integer.toString(i);
            data = readFile(MSSV, name);
            writeFileMerge(MSSV,"orderFile", data);
            System.out.println("Gop file thanh cong. ");
        }
        for(int i = 1; i <= Integer.parseInt(countString); i++){
            String name = "orderFile" + Integer.toString(i);
            deleteFile(MSSV, name);
        }
    }"}