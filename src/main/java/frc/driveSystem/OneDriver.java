package frc.driveSystem;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OneDriver implements ArcadeDriver {

    private ControlSet controlSet;

    public OneDriver(ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    public double getSpeed() {
        return controlSet.getXboxControllerDriver().getY(Hand.kLeft);
    }

    public double getRotation() {
        return controlSet.getXboxControllerDriver().getX(Hand.kRight);
    }

    public boolean getUseSquares() {
        return true;
    }

}