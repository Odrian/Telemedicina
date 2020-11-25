import javafx.application.Application;
import javafx.stage.Stage;

public class _Main extends Application { // Главный метод
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Authorization.author();
    }
}
