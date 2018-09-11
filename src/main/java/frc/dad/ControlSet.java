package frc.dad;

import edu.wpi.first.wpilibj.Joystick;

public class ControlSet {
    private Joystick rightJoystick;
    private Joystick leftJoystick;
    

    public ControlSet(Joystick rightJoystick, Joystick leftJoystick) {
        super();
        this.rightJoystick = rightJoystick;
        this.leftJoystick = leftJoystick;
    }

    /**
     * @return the leftJoystick
     */
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    /**
     * @return the rightJoystick
     */
    public Joystick getRightJoystick() {
        return rightJoystick;
    }

}