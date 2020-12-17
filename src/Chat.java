import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.util.Arrays;

public class Chat {
    private static Scene S_Chat = new Scene(new Pane());
    private static Pane P_chat;
    private static Pane P_info;
    private static Object[] files = {};
    private static String ID;

    public static void start(String id){
        ID = id;
        setup();
    }

    private static void setup(){
        mainPage.stage.setScene(S_Chat);
        P_chat = chat();
        P_info = info();
        S_Chat.setRoot(P_chat);
        mainPage.stage.setWidth(mainPage.stage.getWidth() + 0.001);
    }

    private static Pane message(String[] Data){
        if (Data.length != 4){System.err.println("error length data");return new Pane();}
        String[] time = Data[3].split(" ");

        String ArialPath = "file:fonts/Arial.ttf";
        Text T_name = new Text(Data[1]);
        Text T_msg = new Text(Data[2]);
        Text T_time = new Text(time[0]);
        T_name.setFont(Font.loadFont(ArialPath, 16));
        T_msg.setFont(new Font(20));
        T_msg.wrappingWidthProperty().bind(S_Chat.widthProperty().subtract(100));
        T_time.setFont(Font.loadFont(ArialPath, 10));

        HBox L_Auth = new HBox(T_name, T_time);
        L_Auth.setSpacing(5);

        VBox L_messageText = new VBox(L_Auth, T_msg);
        L_messageText.setPadding(new Insets(3, 0, 0, 0));

        int I_size = 16;
        ImageView I_avatar = new ImageView(new Image("file:pic/avatars/" + Data[0] + ".png"));
        I_avatar.setClip(new Circle(I_size, I_size, I_size));
        I_avatar.setFitHeight(I_size * 2); I_avatar.setFitWidth(I_size * 2);
        I_avatar.setOnMouseClicked(e -> {
            // Переход к профилю человека
        });

        HBox L_msg = new HBox(I_avatar, L_messageText);
        L_msg.setSpacing(5);

        return L_msg;
    }

    private static Pane chat(){
        Button B_back = new Button("", new ImageView(new Image("file:pic/back.png")));
        B_back.setPrefSize(16, 16);
        B_back.setStyle("-fx-background-color: transparent;");
        B_back.setAlignment(Pos.CENTER_LEFT);
        Button B_info = new Button("", new ImageView(new Image("file:pic/info.png")));
        B_info.setMaxSize(16, 16);
        B_info.setStyle("-fx-background-color: transparent;");
        B_info.setPrefSize(16, 16);
        B_info.setAlignment(Pos.CENTER_RIGHT);
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        B_back.setOnAction(e -> mainPage.start());
        B_info.setOnAction(e -> S_Chat.setRoot(P_info));
        HBox upPane = new HBox(B_back, spacer, B_info);
        upPane.setStyle("-fx-background-color: rgb(30,160,230);");
        upPane.setMaxHeight(40);


        ImageView I_addFile = new ImageView(new Image("file:pic/addFile.png"));
        Button B_addFile = new Button("", I_addFile);
        B_addFile.setStyle("-fx-background-color: transparent;");
        TextField TF_msg = new TextField();
        HBox.setHgrow(TF_msg, Priority.SOMETIMES);
        TF_msg.setPadding(new Insets(10, 0, 0, 0));
        TF_msg.setStyle("-fx-border-color: #CCCCCC;" +
                "-fx-background-color: transparent;" +
                "-fx-border-radius: 20px;" +
                "-fx-padding: 10 0 0 0;" +
                "-fx-padding: 0.333333em 1em 0.333333em 1em;");
        TF_msg.setFont(new Font(16));
        TF_msg.setLayoutY(4);
        ImageView I_send = new ImageView(new Image("file:pic/send.png"));
        Button B_send = new Button("", I_send);
        B_send.setStyle("-fx-background-color: transparent;");
        FileChooser fileChooser = new FileChooser();
        B_addFile.setOnAction(e -> files = fileChooser.showOpenMultipleDialog(mainPage.stage).toArray());
        B_send.setOnAction(e ->{
            String msg = TF_msg.getText();
            TF_msg.setText("");
            if (!(msg.equals("") && Arrays.equals(files, new Object[]{}))) {
                String d = ";me,Me," + msg + "," + "17:39 17.12.20";
                DataServer.sendMsg(ID, d, files);
                setup();
            }
        });
        HBox send = new HBox(B_addFile, TF_msg, B_send);
        send.setMinHeight(44);
        send.setMaxHeight(100);

        VBox messages = new VBox();
        messages.setAlignment(Pos.BOTTOM_CENTER);
        messages.setSpacing(15);
        messages.setPadding(new Insets(20));
        for (String[] LowData : DataServer.getData(ID)){
            messages.getChildren().add(message(LowData));
        }
        ScrollPane S_messages = new ScrollPane(messages);
        S_messages.setVvalue(1);

        Pane LowSpace = new Pane();
        LowSpace.setMinHeight(5);

        return new VBox(upPane, S_messages, LowSpace, send);
    }

    private static Pane info(){

        return new Pane();
    }
}
