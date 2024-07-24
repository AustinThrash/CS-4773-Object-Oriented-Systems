module cs4773.hw4 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens cs4773.hw4 to javafx.fxml;
    exports cs4773.hw4 to javafx.graphics;
    opens viewModel to javafx.fxml;
    exports viewModel;
    exports model to javafx.graphics;
}
