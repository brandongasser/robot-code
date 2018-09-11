package frc.driveSystem;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class TwoOperator implements Operator {

    ControlSet controlSet;

    public TwoOperator(ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    public double getLiftSpeed() {
        return controlSet.getXboxController().getY(Hand.kLeft);
    }

    public double getIntakeSpeed() {
        return controlSet.getXboxController().getY(Hand.kRight);
    }
}