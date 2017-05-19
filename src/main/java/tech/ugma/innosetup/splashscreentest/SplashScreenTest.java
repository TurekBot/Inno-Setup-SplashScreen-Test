package tech.ugma.innosetup.splashscreentest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.SplashScreen;

/**
 * An attempt to show potential issues with the splash screen when installing an application
 * as a Native Bundle.
 */
public class SplashScreenTest extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Splash Screen Test");

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Text("For your convenience: "));

        CheckBox splashScreen = new CheckBox("Was there a splash screen?");


        VBox options = new VBox();
        options.getChildren().add(splashScreen);
        borderPane.setCenter(options);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();

        //Because an AWT window is never shown (we're using a JavaFX window) the SplashScreen
        //never goes away by itself.
        //So I close it here:
        final SplashScreen splash;
        if ((splash = SplashScreen.getSplashScreen()) != null) {
            splash.close();
        }
    }
}
