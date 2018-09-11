package frc.driveSystem;

public class TwoDriver implements ArcadeDriver {

    private ControlSet controlSet;

    public TwoDriver(ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    public double getSpeed() {
        return(controlSet.getLeftStick().getY());
    }

    public double getRotation() {
        return(controlSet.getLeftStick().getX());
    }

    public boolean getUseSquares() {
        return false;
    }

}