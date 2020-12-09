import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
В setup() в приватные переменные задаются панели, кнопками сцене задаются другие панели,
таким образом каждый переход на другое окно не нужно задаво создавать панели
 */

public class Authorization { // Авторизация
    private static Stage stage = new Stage();
    private static Scene scene = new Scene(new VBox());
    private static Pane P_page;
    private static Pane P_login;
    private static Pane P_regist;
    private static Pane P_restorePsw;

    // Тут будет проверка был ли вход в аккаунт
    public static void start(){
        setup();
    }

    // Запускает окно входа
    public static void setup(){
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(400);
        stage.setTitle("Telemedecina");
        stage.setResizable(false);
        P_page = page();
        P_login = login();
        P_regist = regist();
        P_restorePsw = restorePassword();
        scene.setRoot(P_page);
        stage.show();
    }

    // Добавляет кнопку назад сверху-слева
    private static Pane upPane(Pane pane, Pane backPane, boolean flag){
        HBox upPane = new HBox();
        if (flag) {
            Button B_back = new Button("", new ImageView(new Image("file:pic/back.png")));
            B_back.setPrefSize(16, 16);
            B_back.setStyle("-fx-background-color: transparent;");
            B_back.setOnAction(e ->{
                scene.setRoot(backPane);
            });
            upPane.getChildren().add(B_back);
        } else {
            upPane.setMinHeight(40);
        }
        upPane.setAlignment(Pos.CENTER_LEFT);
        //upPane.setSpacing(10);
        upPane.setStyle("-fx-background-color: rgb(30,160,230);");
        pane.setPrefHeight(580);
        return new VBox(upPane, pane);
    }



    // окно выбора типа входа
    private static Pane page() {
        Image I_logo = new Image("file:pic/logo.png");
        ImageView IV_logo = new ImageView(I_logo);
        IV_logo.setFitHeight(200); IV_logo.setFitWidth(200);

        Button B_login = new Button("Вход");
        Button B_regist = new Button("Регистрация");
        Button B_gos = new Button("Гос-Услуги");

        B_login.setPrefSize(200, 70);
        B_regist.setPrefSize(200, 70);
        B_gos.setPrefSize(200, 70);

        StackPane L_logo = new StackPane(IV_logo);
        L_logo.setPadding(new Insets(3, 0, 0, 0));

        VBox L_mainBox = new VBox(L_logo, B_login, B_regist, B_gos);
        L_mainBox.setStyle("-fx-background-color: silver;");
        L_mainBox.setAlignment(Pos.CENTER);
        L_mainBox.setSpacing(18);

        B_login.setOnAction(e -> {
            scene.setRoot(P_login);
        });

        B_regist.setOnAction(e -> {
            scene.setRoot(P_regist);
        });

        B_gos.setOnAction(e -> {
            // вход через гос-услуги
        });
        return upPane(L_mainBox, new Pane(), false);
    }

    // Окно входа
    private static Pane login(){
        Image I_logo = new Image("file:pic/logo.png");
        ImageView IV_logo = new ImageView(I_logo);
        IV_logo.setFitHeight(200); IV_logo.setFitWidth(200);

        Text T_login = new Text("Логин");
        TextField TF_login = new TextField();
        Text T_psw = new Text("Пароль");
        PasswordField PF_psw = new PasswordField();

        Text T_ucp = new Text("Неверный логин или пароль, ");
        T_ucp.setOnMouseClicked(e -> {
            scene.setRoot(P_restorePsw);
        });

        Button B_submit = new Button("Войти");
        B_submit.setOnAction(e -> {
            System.out.println("Вход");
            // проверка правельности логина и пароля
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
        L_VBox.setSpacing(10);
        L_VBox.setPadding(new Insets(20));

        StackPane L_image = new StackPane(IV_logo);
        L_image.setAlignment(Pos.CENTER);
        L_image.setPadding(new Insets(30, 20, 0, 20));

        VBox L_mainBox = new VBox(L_image, L_VBox);
        L_mainBox.setStyle("-fx-background-color: silver;");

        return upPane(L_mainBox, P_page, true);
    }

    // Окно регестрации
    private static Pane regist(){
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

        B_submit.setOnAction(e -> {
            errPhone.setVisible(false);
            errPsw1.setText("");
            errPsw2.setVisible(false);

            String phone = TF_Phone.getText();
            String psw1 = PF_psw.getText();
            String psw2 = PF_psw2.getText();
            if (phone.matches("7\\d{10}")){
                if (psw1.length() >= 6){
                    if (psw1.matches("\\w*")){
                        if (psw1.equals(psw2)){
                            System.out.println("Регестрация");
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

        VBox L_mainBox = new VBox(L_up, L_psw1, L_psw2, B_submit);
        L_mainBox.setAlignment(Pos.CENTER);
        L_mainBox.setSpacing(20);
        L_mainBox.setPadding(new Insets(20));
        L_mainBox.setStyle("-fx-background-color: silver;");

        return upPane(L_mainBox, P_page, true);
    }

    // Окно востановления пароля
    private static Pane restorePassword(){
        Text T_phone = new Text("Телефон");

        TextField TF_Phone = new TextField();
        TF_Phone.setPrefHeight(50);
        Text errPhone = new Text("Неверный телефон");
        errPhone.setVisible(false);

        Button B_submit = new Button("Востановить");
        B_submit.setOnAction(e -> {
            errPhone.setVisible(false);
            if (TF_Phone.getText().matches("7\\d{10}")){
                System.out.println("Востановление пароля");
                // отправляем запрос на сервер
            } else {
                errPhone.setVisible(true);
            }
        });

        VBox L_mainBox = new VBox(T_phone, TF_Phone, B_submit);
        L_mainBox.setAlignment(Pos.CENTER);
        L_mainBox.setSpacing(20);
        L_mainBox.setPadding(new Insets(20));
        L_mainBox.setStyle("-fx-background-color: silver;");

        return upPane(L_mainBox, P_login, true);
    }
}
