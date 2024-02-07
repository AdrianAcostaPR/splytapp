package splytapp.splytapp;

import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JsonController {

    public static void jsonGeneratorMethod(String ENTER, String TAB, String SPACE, Stage stage) {
        File selectedFile = FileHandler.readUploadFile(stage);

        if (selectedFile != null) {
            System.out.println(" ");
            try {

                Scanner fileReader = new Scanner(selectedFile);
                StringBuilder jsonStringBuilder = new StringBuilder();

                while (fileReader.hasNextLine()) {
                    //Begins to read line
                    String stringRow = fileReader.nextLine();

                    //Beginning file reader
                    if (stringRow.equals("---")) {
                        jsonStringBuilder.append("{");

                        System.out.println("{");

                    } else if (stringRow.startsWith(TAB)) {
                        // If true, then this is a first CHILD of YAML
                        String[] fatherAndSonArray = stringRow.split(":");
                        if (fatherAndSonArray.length > 0)
                            if (fatherAndSonArray[1] == null) {

                                String fatherName = fatherAndSonArray[0];
                                jsonStringBuilder.append(TAB).append("\"").append(fatherName).append("\":");

                                System.out.println(TAB + "\"" + fatherName + "\":");
                            }

                    } else if (stringRow.contains(":")){ // this is the parent of YAML
                        String[] fatherAndSonArray = stringRow.split(":");

                        if (fatherAndSonArray.length > 1) {
                            //This needs more research.
                            //This will check for the [-] and place it inside an object.
                            if (fatherAndSonArray[0].startsWith(SPACE) && fatherAndSonArray[0].contains("-")) {
                                String fatherName = fatherAndSonArray[0];
                                String fatherValue = fatherAndSonArray[1];

                                //Check if this is correct.
                                jsonStringBuilder.append(TAB).append(TAB).append("[");
                                jsonStringBuilder.append(TAB).append("\"").append(fatherName).append("\":");
                                jsonStringBuilder.append("\"").append(fatherValue).append("\",");
                                jsonStringBuilder.append(ENTER);

                                System.out.println(TAB + TAB + "[");
                                System.out.print(TAB + "\"" + fatherName + "\":");
                                System.out.print("\"" + fatherValue + "\",");
                                System.out.print(ENTER);

                            } else if (fatherAndSonArray[1] != null) {
                                String fatherName = fatherAndSonArray[0];
                                String fatherValue = fatherAndSonArray[1];

                                //This if checks for | and places the "Elements" in a list.
                                if (fatherValue.contains("|")) {

                                    jsonStringBuilder.append(TAB).append("\"").append(fatherName).append("\":");
                                    jsonStringBuilder.append(TAB).append("[");
                                    jsonStringBuilder.append(ENTER);

                                    System.out.println();
                                    System.out.print(TAB + "\"" + fatherName + "\":");
                                    System.out.print(TAB + "[");
                                    System.out.print(ENTER);

                                } else {
                                    jsonStringBuilder.append(TAB).append("\"").append(fatherName).append("\":");
                                    jsonStringBuilder.append("\"").append(fatherValue).append("\",");
                                    jsonStringBuilder.append(ENTER);

                                    System.out.print(TAB + "\"" + fatherName + "\":");
                                    System.out.print("\"" + fatherValue + "\",");
                                    System.out.print(ENTER);
                                }

                            } else {
                                String fatherName = fatherAndSonArray[0];

                                jsonStringBuilder.append(TAB).append("\"").append(fatherName).append("\":");
                                jsonStringBuilder.append(ENTER);

                                System.out.print(TAB + "\"" + fatherName + "\":");
                                System.out.print(ENTER);

                            }

                            //Checks if there is an empty string or space on the YAML File
                        } else if (fatherAndSonArray[0].isEmpty()) {
                            jsonStringBuilder.append(TAB).append(TAB).append("]").append(",");
                            jsonStringBuilder.append(TAB).append("}");
                            jsonStringBuilder.append(ENTER);

                            System.out.println(TAB + TAB + "]" + ",");
                            System.out.println(TAB + "}" + ",");
                            System.out.println(ENTER);

                        } else {
                            String fatherName = fatherAndSonArray[0];
                            //This will create the Father
                            jsonStringBuilder.append(TAB).append("\"").append(fatherName).append("\": {");

                            System.out.println(TAB + "\"" + fatherName + "\": {");
                        }
                    } else {
                        /*
                         * This condition is to validate those elements that do not contain : so that they can be
                         * created into a list
                         * */
                        String[] fatherAndSonArray = stringRow.split(":");
                        String fatherName = fatherAndSonArray[0];

                        jsonStringBuilder.append(TAB).append(TAB).append("\"").append(fatherName).append("\"");

                        System.out.println(TAB + TAB + "\"" + fatherName + "\"");
                    }
                }

                System.out.println(jsonStringBuilder.toString());
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
