import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

class ChatAudio {
    public static Stage stage = new Stage();
    private static Scene scene = new Scene(new Pane());
    private static Pane pane = new Pane();

    public static void start(){
        setup();
        call();
    }

    private static void setup(){
        pane = pane();
    }

    private static Pane pane(){

        return new Pane();
    }

    private static void call(){
        AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
        TargetDataLine microphone;
        SourceDataLine speakers;
        try {
            microphone = AudioSystem.getTargetDataLine(format);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int numBytesRead;
            int CHUNK_SIZE = 1024;
            byte[] data = new byte[microphone.getBufferSize() / 5];
            microphone.start();

            int bytesRead = 0;
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, format);
            speakers = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            speakers.open(format);
            speakers.start();
            while (bytesRead < 100000) {
                numBytesRead = microphone.read(data, 0, CHUNK_SIZE);
                bytesRead += numBytesRead;
                out.write(data, 0, numBytesRead);
                speakers.write(data, 0, numBytesRead);
            }
            speakers.drain();
            speakers.close();
            microphone.close();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
