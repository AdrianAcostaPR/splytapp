package splytapp.splytapp;

import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YamlController {
    public static String yamlGeneratorMethod(String ENTER, String TAB, String SPACE, Stage stage) {

        File selectedFile = FileHandler.readUploadFile(stage);
        String yamlOutput = null;

        if (selectedFile != null) {
            try {
                Scanner fileReader = new Scanner(selectedFile);
                StringBuilder yamlStringBuilder = new StringBuilder();

                while (fileReader.hasNextLine()) {
                    //Begins to read line
                    String stringRow = fileReader.nextLine();

                    //Beginning file reader
                    if (stringRow.equals("{")) {

                        yamlStringBuilder.append("---" + ENTER);
                        System.out.print("---" + ENTER);

                    } else if (stringRow.startsWith(TAB)) {
                        //If true, then this is a first child or JSON
                        String[] fatherAndSonArray = stringRow.split(":");
                        if (fatherAndSonArray.length > 0)
                            if (fatherAndSonArray[1] == null) {

                                String fatherName = fatherAndSonArray[0];
                                yamlStringBuilder.append(TAB + fatherName + ":");
                                System.out.print(TAB + fatherName + ":");

                            }
                    } else if (stringRow.contains(":")) { //This is the parent of JSON
                        String[] fatherAndSonArray = stringRow.split(":");

                        if (fatherAndSonArray.length > 1) {
                            //Check if [-] necessary
                            if (fatherAndSonArray[0].startsWith(SPACE) && fatherAndSonArray[0].contains("-")) {
                                String fatherName = fatherAndSonArray[0];
                                String fatherValue = fatherAndSonArray[1];

                                yamlStringBuilder.append(TAB + TAB + "Testing");
                                yamlStringBuilder.append(TAB + fatherName + ":");
                                yamlStringBuilder.append(fatherValue);
                                yamlStringBuilder.append(ENTER);

                                System.out.print(TAB + TAB + "Testing");
                                System.out.print(TAB + fatherName + ":");
                                System.out.print(fatherValue);

                            } else if (fatherAndSonArray[1] != null) {
                                String fatherName = fatherAndSonArray[0];
                                String fatherValue = fatherAndSonArray[1];

                                //This if checks for | and places the "Elements" in a list. Might not be needed
                                if (fatherValue.contains("|")) {
                                    yamlStringBuilder.append(TAB + fatherName + ":");
                                    yamlStringBuilder.append(TAB + "[");
                                    yamlStringBuilder.append(ENTER);

                                    System.out.print(TAB + fatherName + ":");
                                    System.out.print(TAB + "[");
                                    System.out.print(ENTER);

                                } else if (fatherValue.equals(" {")) {
                                    yamlStringBuilder.append(TAB + fatherName + ":");
                                    yamlStringBuilder.append("");
                                    yamlStringBuilder.append(ENTER);

                                    System.out.print(TAB + fatherName + ":");
                                    System.out.print("");
                                    System.out.print(ENTER);
                                } else {
                                    String removeFatherValueComma = fatherValue.replace(",", "");
                                    yamlStringBuilder.append(TAB + fatherName + ":");
                                    yamlStringBuilder.append(removeFatherValueComma);
                                    yamlStringBuilder.append(ENTER);

                                    System.out.print(TAB + fatherName + ":");
                                    System.out.print(removeFatherValueComma);
                                    System.out.print(ENTER);
                                }
                            } else {
                                String fatherName = fatherAndSonArray[0];
                                yamlStringBuilder.append(TAB + fatherName + ":");
                                yamlStringBuilder.append(ENTER);

                                System.out.print(TAB + fatherName + ":");
                                System.out.print(ENTER);
                            }

                            //Checks if there is an empty string or space on the JSON File
                        } else if (fatherAndSonArray[0].isEmpty()) {
                            yamlStringBuilder.append(TAB + TAB + "]");
                            yamlStringBuilder.append(TAB + "}");
                            yamlStringBuilder.append(ENTER);

                            System.out.print(TAB + TAB + "]");
                            System.out.print(TAB + "}");
                            System.out.print(ENTER);

                        } else {
                            String fatherName = fatherAndSonArray[0];
                            //This will create the Father
                            yamlStringBuilder.append(TAB + fatherName + ": {");
                            System.out.print(TAB + fatherName + ": {");

                        }

                    } else {
                        /*
                         * This condition is to validate those elements that do not contain : so that they can be
                         * created into a list
                         * */
                        String[] fatherAndSonArray = stringRow.split(":");
                        String fatherName = fatherAndSonArray[0];

                        /*Checks for closing bracket } with a comma , then replaces it with empty string*/
                        if (fatherName.contains("}") && fatherName.contains(",")) {
                            String emptyString = "";
                            yamlStringBuilder.append(TAB + TAB + emptyString);
                            System.out.print(TAB + TAB + emptyString);

                        } else if (fatherName.contains("}")) {//checks if there is a closing bracket then removes it.
                            String removeFatherNameClosingBracket = fatherName.replace("}", "");
                            yamlStringBuilder.append(TAB + TAB + removeFatherNameClosingBracket);
                            System.out.print(TAB + TAB + removeFatherNameClosingBracket);

                        } else { //prints last option
                            //Remove Commas
                            yamlStringBuilder.append(TAB + fatherName + ENTER);
                            System.out.print(TAB + fatherName + ENTER);
                        }
                    }
                }
                yamlOutput = yamlStringBuilder.toString();
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return yamlOutput;
    }
}