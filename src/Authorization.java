import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/*
В setup() в приватные переменные задаются панели, кнопками сцене задаются другие панели,
таким образом каждый переход на другое окно не нужно задаво создавать панели
 */

public class Authorization { // Авторизация
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
    void initialize() {
        login();
    }

    private void login(){
        EnterBtn.setOnAction(e -> {
            String S_login = LogField.getText();
            String S_psw = PasField.getText();


            boolean flag = true;
            for (String[] lowData : FileScan.fileGet("Data/UsersData.txt")) {
                if (S_login.equals(lowData[0])) {
                    if (S_psw.equals(lowData[1])) {
                        error.setText("Всё верно ✓");
                        String id = DataServer.login(LogField.getText(), PasField.getText());
                        if (!id.equals("")) {
                            // закрытие этого окна
                            mainPage.Id = id;
                            mainPage.start();
                        }
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
}
