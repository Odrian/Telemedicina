import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class _Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/NeoAuth.fxml"));
            primaryStage.setTitle("Медицина");
            primaryStage.setScene(new Scene(root, 700, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Не удалось загрузить fxml файл окна входа!");
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        PushNotif.close();
    }

    public static void main(String[] args) {
        //PushNotif.start();
        launch(args);
    }
}
