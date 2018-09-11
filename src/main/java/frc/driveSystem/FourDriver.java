package frc.driveSystem;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class FourDriver implements TankDriver {
    private ControlSet controlSet;

    public FourDriver(ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    public double getLeftSpeed() {
        return controlSet.getXboxControllerDriver().getY(Hand.kLeft);
    }

    public double getRightSpeed() {
        return controlSet.getXboxControllerDriver().getY(Hand.kRight);
    }

    public boolean getUseSquares() {
        return false;
    }
}