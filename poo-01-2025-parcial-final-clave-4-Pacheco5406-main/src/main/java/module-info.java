module com.parcialfinal.regalofisico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.parcialfinal.regalofisico to javafx.fxml;
    exports com.parcialfinal.regalofisico;
    exports com.parcialfinal.regalofisico.Controladores;
    opens com.parcialfinal.regalofisico.Controladores to javafx.fxml;
    exports com.parcialfinal.regalofisico.Controladores.DAO;
    opens com.parcialfinal.regalofisico.Controladores.DAO to javafx.fxml;
}