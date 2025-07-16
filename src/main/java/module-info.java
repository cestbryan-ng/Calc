module javafxtest.calcfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens javafxtest.calcfx to javafx.fxml;
    exports javafxtest.calcfx;
}