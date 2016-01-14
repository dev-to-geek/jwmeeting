/*******************************************************************************
 * This file is part of JWMeeting.
 * <p>
 * JWMeeting is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * JWMeeting is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with JWMeeting.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.dev2geek.jwmeeting.fe;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dev2geek.jwmeeting.fe.controllers.MainController;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Class: Main
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public class Main extends Application {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        log.debug("void main()");

        launch(args);
    }

    private static void generateSnapshotOfNode(Node node, String fileName) throws IOException {
        WritableImage snapshot = node.snapshot(new SnapshotParameters(), null);
        File file = new File(fileName);
        ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.debug("start");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/main.fxml"));

        Parent root = fxmlLoader.load();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("JWMeeting");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();

        final MainController controller = fxmlLoader.getController();
        controller.setStage(primaryStage);

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX(0);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 4);

        generateSnapshotOfNode(root, "snapshot.png");
    }
}
