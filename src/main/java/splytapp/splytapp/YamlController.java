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

                        yamlStringBuilder.append("---");

                    } else if (stringRow.startsWith(TAB)) {
                        //If true, then this is a first child or JSON
                        String[] fatherAndSonArray = stringRow.split(":");
                        if (fatherAndSonArray.length > 0)
                            if (fatherAndSonArray[1] == null) {

                                String fatherName = fatherAndSonArray[0];
                                yamlStringBuilder.append(TAB).append(fatherName).append(":");

                            }
                    } else if (stringRow.contains(":")) { //This is the parent of JSON
                        String[] fatherAndSonArray = stringRow.split(":");

                        if (fatherAndSonArray.length > 1) {
                            //Check if [-] necessary
                            if (fatherAndSonArray[0].startsWith(SPACE) && fatherAndSonArray[0].contains("-")) {
                                String fatherName = fatherAndSonArray[0];
                                String fatherValue = fatherAndSonArray[1];

                                yamlStringBuilder.append(TAB).append(TAB).append("Testing");
                                yamlStringBuilder.append(TAB).append(fatherName).append(":");
                                yamlStringBuilder.append(fatherValue);
                                yamlStringBuilder.append(ENTER);

                            } else if (fatherAndSonArray[1] != null) {
                                String fatherName = fatherAndSonArray[0];
                                String fatherValue = fatherAndSonArray[1];

                                //This if checks for | and places the "Elements" in a list. Might not be needed
                                if (fatherValue.contains("|")) {
                                    yamlStringBuilder.append(TAB).append(fatherName).append(":");
                                    yamlStringBuilder.append(TAB).append("[");
                                    yamlStringBuilder.append(ENTER);

                                } else if (fatherValue.equals(" {")) {
                                    yamlStringBuilder.append(TAB).append(fatherName).append(":");
                                    yamlStringBuilder.append("");
                                    yamlStringBuilder.append(ENTER);
                                } else {
                                    String removeFatherValueComma = fatherValue.replace(",", "");
                                    yamlStringBuilder.append(TAB).append(fatherName).append(":");
                                    yamlStringBuilder.append(removeFatherValueComma);
                                    yamlStringBuilder.append(ENTER);
                                }
                            } else {
                                String fatherName = fatherAndSonArray[0];
                                yamlStringBuilder.append(TAB).append(fatherName).append(":");
                                yamlStringBuilder.append(ENTER);
                            }

                            //Checks if there is an empty string or space on the JSON File
                        } else if (fatherAndSonArray[0].isEmpty()) {
                            yamlStringBuilder.append(TAB).append(TAB).append("]");
                            yamlStringBuilder.append(TAB).append("}");
                            yamlStringBuilder.append(ENTER);

                        } else {
                            String fatherName = fatherAndSonArray[0];
                            //This will create the Father
                            yamlStringBuilder.append(TAB).append(fatherName).append(": {");

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
                            yamlStringBuilder.append(TAB).append(TAB).append(emptyString);

                        } else if (fatherName.contains("}")) {//checks if there is a closing bracket then removes it.
                            String removeFatherNameClosingBracket = fatherName.replace("}", "");
                            yamlStringBuilder.append(TAB).append(TAB).append(removeFatherNameClosingBracket);

                        } else { //prints last option
                            yamlStringBuilder.append(TAB).append(TAB).append(fatherName);
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