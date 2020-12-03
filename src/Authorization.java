import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Authorization { // Авторизация
    public static void start(){ // запускается первым, проверка наличия сеанса
        String session = FileRead.getSession();
        if (session.equals("")){
            page();
        }else{
            //проверка сессии
        }
    }

    public static void page() { // окно выбора типа входа
        login();//для удобства
    }

    public static void login(){ // Окно входа
        Image I_logo = new Image("file:pic/logo.png");
        ImageView IV_logo = new ImageView(I_logo);
        IV_logo.setFitHeight(200); IV_logo.setFitWidth(200);

        Text T_login = new Text("Логин");
        TextField TF_login = new TextField();
        Text T_psw = new Text("Пароль");
        PasswordField PF_psw = new PasswordField();
        Hyperlink T_ucp = new Hyperlink("Неверный логин или пароль");
        T_ucp.setVisited(true);
        T_ucp.setVisible(true);
        Button B_submit = new Button("Войти");

        T_ucp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // если забыл пароль
            }
        });
        B_submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // проверка правельности логина и пароля
            }
        });

        Font F_a20 = new Font(20);
        T_login.setFont(F_a20); TF_login.setFont(F_a20); T_psw.setFont(F_a20); PF_psw.setFont(F_a20); B_submit.setFont(F_a20);
        TF_login.setPrefHeight(50); PF_psw.setPrefHeight(50);

        StackPane L_submit = new StackPane(B_submit);
        L_submit.setAlignment(Pos.CENTER);

        VBox L_up = new VBox(T_login, TF_login);
        L_up.setSpacing(10);

        VBox L_psw = new VBox(T_psw, PF_psw, T_ucp, L_submit);
        L_psw.setSpacing(10);

        VBox L_VBox = new VBox(L_up, L_psw);
        L_VBox.setAlignment(Pos.CENTER);
        L_VBox.setSpacing(40);
        L_VBox.setPadding(new Insets(20));

        StackPane L_image = new StackPane(IV_logo);
        L_image.setAlignment(Pos.CENTER);
        L_image.setPadding(new Insets(30, 20, 0, 20));

        VBox L_mainBox = new VBox(L_image, L_VBox);
        L_mainBox.setStyle("-fx-background-color: rgb(30,160,230);");

        Scene scene = new Scene(L_mainBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(400);
        stage.setTitle("Вход");
        stage.setResizable(false);
        stage.show();
    }

    public static void regist(){ // Окно регестрации

    }
}
