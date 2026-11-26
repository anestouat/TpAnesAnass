module ca.qc.bdeb.sim.tpanesetanass {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.qc.bdeb.sim.tpanesetanass to javafx.fxml;
    exports ca.qc.bdeb.sim.tpanesetanass;
}