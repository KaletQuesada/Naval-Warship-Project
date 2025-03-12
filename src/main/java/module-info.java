module com.mycompany.thebattleships {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.media;

    opens com.mycompany.thebattleships to javafx.fxml;
    exports com.mycompany.thebattleships;
}
