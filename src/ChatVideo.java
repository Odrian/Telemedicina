import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


class ChatVideo {
    private static Stage stage;
    private static Image image;

    public static void start(){
        stage = new Stage();
        stage.setScene(new Scene(pane()));
        stage.show();
        video();
    }

    private static Pane pane(){
        ImageView IV = new ImageView(image);
        return new Pane(IV);
    }

    private static void video(){
        image = new Image("");
    }

    public static void close(){
        stage.close();
    }
}
