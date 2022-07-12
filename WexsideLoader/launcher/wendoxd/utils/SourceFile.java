/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javafx.fxml.FXML
 *  javafx.scene.input.MouseEvent
 *  javafx.scene.layout.Pane
 */
package launcher.wendoxd.utils;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import launcher.SourceFile3;

public class SourceFile {
    private static Pane pane;
    private static double x;
    private static double y;

    @FXML
    @SourceFile3
    public void onDragged(MouseEvent mouseEvent) {
        pane.getScene().getWindow().setX(mouseEvent.getScreenX() - x);
        pane.getScene().getWindow().setY(mouseEvent.getScreenY() - y);
    }

    @FXML
    @SourceFile3
    public void onPressed(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
    }

    @SourceFile3
    public static void setPane(Pane pane) {
        SourceFile.pane = pane;
    }
}

