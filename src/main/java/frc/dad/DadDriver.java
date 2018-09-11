package frc.dad;


public class DadDriver implements Driver {
    private ControlSet controlSet;

    public DadDriver (ControlSet controlSet) {
        this.controlSet = controlSet;
    }

    @Override
    public double getSpeed() {
        return controlSet.getLeftJoystick().getX();
    }

    @Override
    public double getRotation() {
        return 0;
    }

}