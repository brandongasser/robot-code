package frc.driveSystem;

public class ThreeOperator implements Operator {

    private ControlSet controlSet;

    public ThreeOperator(ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    public double getLiftSpeed() {
        if (controlSet.getXboxController().getYButton()) {
            return 1.0;
        } else if (controlSet.getXboxController().getAButton()) {
            return -1.0;
        } else {
            return 0.0;
        }
    }

    public double getIntakeSpeed() {
        if (controlSet.getXboxController().getXButton()) {
            return -1.0;
        } else if (controlSet.getXboxController().getBButton()) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}