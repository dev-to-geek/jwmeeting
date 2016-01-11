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
package org.dev2geek.jwmeeting.fe.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class: MainController
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public class MainController {
    @FXML
    private Button closeButton;

    private Stage stage;
    private double dragAnchorX;
    private double dragAnchorY;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void closeStage(ActionEvent actionEvent) {
        stage.close();
    }

    @FXML
    public void mousePressedHandler(MouseEvent me) {
        dragAnchorX = me.getScreenX() - stage.getX();
        dragAnchorY = me.getScreenY() - stage.getY();
    }

    @FXML
    public void mouseDraggedHandler(MouseEvent me) {
        //TODO add snap to corner
        stage.setX(me.getScreenX() - dragAnchorX);
        stage.setY(me.getScreenY() - dragAnchorY);
    }
}
