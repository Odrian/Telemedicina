import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainPage {
    public static Stage main = new Stage();
    private static Scene scene = new Scene(new Pane());

    public static void start(){ // Запуск
        setup();
    }

    private static void setup(){
        main.setScene(scene);
        main.setMinHeight(600);
        main.setMinWidth(400);
        main.setHeight(600);
        main.setWidth(400);
        main.setTitle("Telemedecina");
        main.show();
        Chat.start();
    }
}
