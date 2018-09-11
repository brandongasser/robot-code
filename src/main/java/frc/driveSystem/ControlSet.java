package frc.driveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class ControlSet {

    private XboxController xboxControllerDriver;
    private XboxController xboxControllerOperator;

    public ControlSet (XboxController xboxControllerDriver, XboxController xboxControllerOperator) {
        this.xboxControllerDriver = xboxControllerDriver;
        this.xboxControllerOperator = xboxControllerOperator;
    }

    public XboxController getXboxControllerDriver() {
        return xboxControllerDriver;
    }

    public XboxController getXboxControllerOperator() {
        return xboxControllerOperator;
    }

}