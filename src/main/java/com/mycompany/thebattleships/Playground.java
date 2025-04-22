package com.mycompany.thebattleships;
import javafx.css.Size;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Playground {

    private static final byte SIZE = 10;

    @FXML
    private Button orientationButton;
    @FXML
    private GridPane tableGrid;
    private boolean orientation = true; //if true, the ship is horizontal, else is vertical
    @FXML
    public void changeOrientation(){
        orientation = !orientation;
        orientationButton.setText(orientation ? "Horizontal" : "Vertical");
    }

    public void initialize(){
        createTable();
    }

    private void createTable(){
        byte SIZE = 10;
        for(int row = 0; row < SIZE; row++){
            for(int column = 0; column < SIZE; column++) {
                StackPane grid = new StackPane();
                grid.setPrefSize(40, 40);
                grid.setStyle("-fx-background-color: black; -fx-background-color: lightblue");
                tableGrid.add(grid,row, column);

                grid.setOnDragOver(dragEvent -> {
                    if(dragEvent.getGestureSource() != grid && dragEvent.getDragboard().hasString()){
                        dragEvent.acceptTransferModes(TransferMode.MOVE);
                    }
                    dragEvent.consume();
                });

                grid.setOnDragDropped(event ->{
                    Dragboard dragboard = event.getDragboard();
                    boolean success = false;
                    if(dragboard.hasString()){
                        int size = Integer.parseInt(dragboard.getString());
                        placeShipOnGrid((StackPane) grid, size);
                        success = true;
                    }
                    event.setDropCompleted(success);
                    event.consume();
                });
            }
        }
    }

    private void prepareDragAndDrop(Node ship, int size){
        ship.setOnDragDetected(mouseEvent -> {
            Dragboard dragboard = ship.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(String.valueOf(size));
            dragboard.setContent(content);
            mouseEvent.consume();
        });
    }
    private void placeShipOnGrid(StackPane startGrid, int newSize){
        Integer row = GridPane.getRowIndex(startGrid);
        Integer column = GridPane.getColumnIndex(startGrid);

        if(row == null || column == null) return;

        if (orientation && column + newSize > SIZE)return;
        if (!orientation && row + newSize > SIZE)return;

        for (int i = 0; i < newSize; i++){
            int currentRow = orientation ? row : row + i;
            int currentColumn = orientation ? column + i: column;

            for (Node node : tableGrid.getChildren()) {
                Integer rowNode = GridPane.getRowIndex(node);
                Integer columnNode = GridPane.getColumnIndex(node);

                if (rowNode != null && columnNode != null && rowNode == currentRow && columnNode == currentColumn){
                    StackPane grid = (StackPane) node;
                    grid.setStyle("-fx-background-color: gray; -fx-border-color: black;");
                    grid.setUserData("Ship");
                }
            }
        }

    }
}