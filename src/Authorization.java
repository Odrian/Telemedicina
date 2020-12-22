import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Authorization {

    @FXML
    private Text error;

    @FXML
    private JFXPasswordField PasField;

    @FXML
    private Text AuthTXT;

    @FXML
    private JFXTextField LogField;

    @FXML
    private Button EnterBtn;

    @FXML
    private Text RstrBtn;

    @FXML
    private Text NmOrgTXT;

    @FXML
    private Button RegBtn;

    @FXML
    private Button EnterbyGos;



    // Окно входа
    private void login(){
        EnterBtn.setOnAction(e -> {
            String S_login = LogField.getText();
            String S_psw = PasField.getText();

            boolean flag = true;
            for (String[] lowData : FileScan.fileGet("Data/UsersData.txt")) {
                if (S_login.equals(lowData[0])) {
                    if (S_psw.equals(lowData[1])) {
                        error.setText("Всё верно ✓");
                    } else {
                        // неверный пароль
                        error.setText("Неверный пароль");
                    }
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // неверный логин
                error.setText("Неверный логин");
            }
        });
    }

    // Окно регестрации
    /*private static Pane regist(){
        Text T_Phone = new Text("Номер телефона");
        TextField TF_Phone = new TextField();
        Text errPhone = new Text("");

        Text T_psw = new Text("Пароль");
        PasswordField PF_psw = new PasswordField();
        Text errPsw1 = new Text("");

        Text T_psw2 = new Text("Подтвердите пароль");
        PasswordField PF_psw2 = new PasswordField();
        Text errPsw2 = new Text("");

        Button B_submit = new Button("Зарегествироваться");

        B_submit.setOnAction(e -> {
            errPhone.setText("");
            errPsw1.setText("");
            errPsw2.setText("");

            String phone = TF_Phone.getText();
            String psw1 = PF_psw.getText();
            String psw2 = PF_psw2.getText();
            if (phone.matches("8\\d{10}")){
                if (psw1.length() >= 6){
                    if (psw1.matches("\\w*")){
                        if (psw1.equals(psw2)){
                            boolean flag = true;
                            String S_phone = TF_Phone.getText();
                            for (String[] lowData : FileScan.fileGet("data/UsersData.txt")) {
                                if (S_phone.equals(lowData[0])) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                FileScan.fileAdd("data/UsersData.txt", ";" + S_phone + "," + psw1);
                                stage.close();
                                mainPage.start();
                            } else errPhone.setText("Уже существует аккаунт с таким телефоном");
                        } else errPsw2.setText("Пароли не совподают");
                    } else errPsw1.setText("Можно использовать толь англиский алфовит и цифры");
                } else errPsw1.setText("Минимильная длина пароля - 6");
            } else errPhone.setText("Неверный номер телефона");
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
            } else errPhone.setVisible(true);
        });

        VBox L_mainBox = new VBox(T_phone, TF_Phone, B_submit);
        L_mainBox.setAlignment(Pos.CENTER);
        L_mainBox.setSpacing(20);
        L_mainBox.setPadding(new Insets(20));
        L_mainBox.setStyle("-fx-background-color: silver;");

        return upPane(L_mainBox, P_login, true);
    }*/
}
