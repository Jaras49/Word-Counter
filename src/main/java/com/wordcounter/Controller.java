package com.wordcounter;

import com.wordcounter.counter.WordCounter;
import com.wordcounter.counter.reader.TextReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class Controller {

    private static final String MAIN_WINDOW_FXML_ADRESS = "../../../resources/GUI/MainWindow.fxml";
    private static final String ABOUT_US_PAGE_FXML_ADRESS = "../../../resources/GUI/AboutUsPage.fxml";

    private WordCounter wordCounter = new WordCounter(new TextReader());

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;

    @FXML private void chooseFileButtonClick(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        textArea.setText(wordCounter.getPopularWords(getIntFromTextField(), file).stream()
        .collect(Collectors.joining("\n")));
    }

    @FXML private void aboutButtonClick()throws IOException {
        changeStage(ABOUT_US_PAGE_FXML_ADRESS);
    }

    @FXML private void goBackButtonClick() throws IOException {
        changeStage(MAIN_WINDOW_FXML_ADRESS);
    }

    @FXML private void findButtonClick() {
        textArea.setText(wordCounter.getPopularWords(getIntFromTextField(), textArea.getText()).stream()
                .collect(Collectors.joining("\n")));

    }

    private void changeStage(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = fxmlLoader.load();
        Stage stage = Main.getStage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private int getIntFromTextField() {
        int value;
        try {
            value = Integer.parseInt(textField.getText());
        }catch (NumberFormatException e) {
            value = 3;
        }
        return value;
    }
}
