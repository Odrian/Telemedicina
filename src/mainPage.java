import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainPage {
    public static Stage stage = new Stage();
    private static Scene scene = new Scene(new Pane());
    private static Pane pane;
    private static Pane leftPane;
    private static boolean lp = false;

    public static void start(){ // Запуск
        setupStage();
        setup();
    }

    private static void setupStage(){
        stage.setMinHeight(600);
        stage.setMinWidth(400);
        stage.setHeight(600);
        stage.setWidth(400);
        stage.setTitle("Telemedecina");
        stage.show();
    }

    private static void setup(){
        stage.setScene(scene);
        pane = pane();
        leftPane = leftPane();
        scene.setRoot(pane);
    }

    private static Pane pane(){
        Button B_leftMenu = new Button("", new ImageView(new Image("file:pic/menu.png")));
//        B_leftMenu.setPrefHeight(20);
        B_leftMenu.setStyle("-fx-background-color: transparent;");
        B_leftMenu.setOnAction(e -> {
            if (lp) {
                pane.getChildren().remove(0);
            } else {
                pane.getChildren().add(0, leftPane);
            }
            lp = !lp;
        });

        Button B_update = new Button("", new ImageView(new Image("file:pic/refresh.png")));
//        B_update.setPrefHeight(20);
        B_update.setStyle("-fx-background-color: transparent;");
        B_update.setOnAction(e -> {
            pane = pane();
        });

        Pane space = new Pane();
        HBox.setHgrow(space, Priority.ALWAYS);
        HBox upPane = new HBox(B_leftMenu, space, B_update);
        upPane.setMinHeight(40);
//        upPane.setPrefWidth(Double.MAX_VALUE);
        upPane.setStyle("-fx-background-color: rgb(30,160,230);");


        VBox list = new VBox();
        String[][] data = DataServer.getListMsg();
        for (int i = 0; i < data.length; i++){
            list.getChildren().add(listMsg(data[i]));
        }
        list.setSpacing(8);
        list.setPadding(new Insets(10));
        VBox msgPane = new VBox(list);

        VBox mainPane = new VBox(upPane, msgPane);
        HBox.setHgrow(mainPane, Priority.SOMETIMES);
        return new HBox(mainPane);
    }
    private static HBox listMsg(String[] LowData){
        int I_size = 32;
        ImageView I_avatar = new ImageView(new Image("file:pic/avatars/" + LowData[0] + ".png"));
        I_avatar.setClip(new Circle(I_size, I_size, I_size));
        I_avatar.setFitHeight(I_size * 2); I_avatar.setFitWidth(I_size * 2);

        Text T_name = new Text(LowData[1]);
        Text T_msg = new Text(LowData[2]);

        T_name.setFont(Font.loadFont("file:fonts/Arial.ttf", 24));
        T_msg.setFont(new Font(16));

        VBox L_text = new VBox(T_name, T_msg);
        HBox main = new HBox(I_avatar, L_text);
        HBox.setHgrow(main, Priority.ALWAYS);
        main.setSpacing(8);
        main.setOnMouseClicked(e -> {
            Chat.start(LowData[0]);
        });
        return main;
    }

    private static Pane leftPane(){
        Button backBtn = new Button("Left Arrow");
        backBtn.setPrefWidth(100);
        backBtn.setStyle("");

        Button newBtn = new Button("New");
        newBtn.setPrefWidth(100);
        newBtn.setStyle("");

        VBox menu = new VBox(backBtn, newBtn);
        menu.setStyle("-fx-background-color: gray;");
        menu.setPrefWidth(100);
        return menu;
    }
}
