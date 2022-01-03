package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenuComerciaux {

    public void buttonOuvrirFichesClientsClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();;
            Stage configurationStage = new Stage();

            loader.setLocation(Main.class.getResource("../view/viewListeFichesClients.fxml"));
            Pane configurationLayout = (Pane) loader.load();
            Scene configurationScene = new Scene(configurationLayout);
            configurationStage.setScene(configurationScene);

            configurationStage.setTitle("MeetingsBooker - Fiches Clients");
            configurationStage.initModality(Modality.APPLICATION_MODAL);
            configurationStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
