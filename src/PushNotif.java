import javafx.application.Platform;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class PushNotif {
    private static final Timer timer = new Timer();
    private static TrayIcon trayIcon;
    private static SystemTray tray;

    public static void close(){
        try {
            //tray.remove(trayIcon);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении из трея");
            e.printStackTrace();
        }
    }

    public static void start() {
        try {
            tray = SystemTray.getSystemTray();
            trayIcon = new TrayIcon(ImageIO.read(new File("pic/logo.png")));
        } catch (IOException e) {
            System.out.println("Ошибка при создание трея");
            e.printStackTrace();
        }
        Platform.setImplicitExit(false);
        javax.swing.SwingUtilities.invokeLater(PushNotif::addAppToTray);
    }

    private static void addAppToTray() {
        try {
            if (SystemTray.isSupported()) {
                Toolkit.getDefaultToolkit();
                MenuItem exitItem = new MenuItem("Exit");
                exitItem.addActionListener(event -> tray.remove(trayIcon));

                final PopupMenu popup = new PopupMenu();
                popup.add(exitItem);
                trayIcon.setPopupMenu(popup);
                trayIcon.displayMessage("Telemedecina", "Только сегодня скидка на тесты...", TrayIcon.MessageType.INFO);

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        SwingUtilities.invokeLater(() -> trayIcon.displayMessage(
                                "Telemedecina", "Только сегодня скидка на тесты...", TrayIcon.MessageType.NONE
                        ));
                    }
                }, 1_000, 100_000);
                trayIcon.addActionListener(e -> open());
                tray.add(trayIcon);
            }
        } catch (AWTException e) {
            System.out.println("ошибка при запуске трея");
            e.printStackTrace();
        }
    }

    private static void open(){
        System.out.println("Ты клинкул на уведомление");
    }
}
