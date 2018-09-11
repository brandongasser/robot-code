package frc.driveSystem;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OneOperator implements Operator {

    private ControlSet controlSet;

    public OneOperator(ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    public double getLiftSpeed() {
        if (controlSet.getXboxControllerOperator().getTriggerAxis(Hand.kLeft) >= 0.5 && !(controlSet.getXboxControllerOperator().getTriggerAxis(Hand.kRight) >= 0.5)) {
            return -1.0;
        } else if (controlSet.getXboxControllerOperator().getTriggerAxis(Hand.kRight) >= 0.5 && !(controlSet.getXboxControllerOperator().getTriggerAxis(Hand.kLeft) >= 0.5)) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public double getIntakeSpeed() {
        return controlSet.getXboxControllerOperator().getY(Hand.kRight);
    }

}