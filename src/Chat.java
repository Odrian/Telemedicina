import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Chat {

    @FXML
    private Text MainPageLink;

    @FXML
    private Text Chatlink;

    @FXML
    private Text MedcardLink;

    @FXML
    private ImageView userphoto;

    @FXML
    private Text username;

    @FXML
    private ImageView Bell;

    @FXML
    private SplitPane ChatPane;

    @FXML
    private AnchorPane Dialogs;

    @FXML
    private AnchorPane Chat;

    void initialize(){
        ChatPane.setDividerPositions(0.25f, 0.75f);
        Main.stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double[] positions = ChatPane.getDividerPositions(); // reccord the current ratio
            Platform.runLater(() -> ChatPane.setDividerPositions(positions)); // apply the now former ratio
        });
    }
}

