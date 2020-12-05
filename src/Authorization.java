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
        regist();//для удобства
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
        Text T_Phone = new Text("Номер телефона");
        TextField TF_Phone = new TextField();
        Text errPhone = new Text("Неверный номер телефона"); errPhone.setVisible(false);

        Text T_psw = new Text("Пароль");
        PasswordField PF_psw = new PasswordField();
        Text errPsw1 = new Text("");

        Text T_psw2 = new Text("Подтвердите пароль");
        PasswordField PF_psw2 = new PasswordField();
        Text errPsw2 = new Text("Пароли не совподают"); errPsw2.setVisible(false);

        Button B_submit = new Button("Зарегествироваться");

        B_submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                errPhone.setVisible(false);
                errPsw1.setText("");
                errPsw2.setVisible(false);

                String phone = TF_Phone.getText();
                String psw1 = PF_psw.getText();
                String psw2 = PF_psw2.getText();
                boolean flag = true;
                if (phone.matches("7\\d{10}")){
                    if (psw1.length() >= 6){
                        if (psw1.matches("\\w*")){
                            if (psw1.equals(psw2)){
                                // запрос к серверу на регестрацию
                            } else{
                                errPsw2.setVisible(true);
                            }
                        } else{
                            errPsw1.setText("Можно использовать толь англиский алфовит и цифры");
                        }
                    } else{
                        errPsw1.setText("Минимильная длина пароля - 6");
                    }
                } else{
                    errPhone.setVisible(true);
                }
            }
        });

        Font F_a20 = new Font(20);
        T_Phone.setFont(F_a20); TF_Phone.setFont(F_a20); T_psw.setFont(F_a20); PF_psw.setFont(F_a20); T_psw2.setFont(F_a20); PF_psw2.setFont(F_a20); B_submit.setFont(F_a20);
        TF_Phone.setPrefHeight(50); PF_psw.setPrefHeight(50); PF_psw2.setPrefHeight(50);

        VBox L_up = new VBox(T_Phone, TF_Phone, errPhone);
        L_up.setSpacing(8);

        VBox L_psw1 = new VBox(T_psw, PF_psw, errPsw1);
        L_psw1.setSpacing(8);

        VBox L_psw2 = new VBox(T_psw2, PF_psw2, errPsw2);
        L_psw2.setSpacing(8);

        StackPane L_submit = new StackPane(B_submit);
        L_submit.setAlignment(Pos.CENTER);

        VBox L_mainBox = new VBox(L_up, L_psw1, L_psw2, L_submit);
        L_mainBox.setAlignment(Pos.CENTER);
        L_mainBox.setSpacing(20);
        L_mainBox.setPadding(new Insets(20));
        L_mainBox.setStyle("-fx-background-color: rgb(30,160,230);");

        Scene scene = new Scene(L_mainBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(400);
        stage.setTitle("Регестрация");
        stage.setResizable(false);
        stage.show();
    }
}
