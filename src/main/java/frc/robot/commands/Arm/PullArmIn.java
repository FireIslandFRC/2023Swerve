package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.Variables;
import frc.robot.subsystems.*;

//this is drew
public class PullArmIn extends CommandBase {
    private final Timer m_timer = new Timer();

    public static boolean done = false;

    @Override
    public void initialize() {
        m_timer.start();
        done = false;
    }

    @Override
    public void execute() {
        if (Functions.LimitInOutValue()){
            Functions.Arm_extend(-Variables.ArmExtendSpeed);
        }else if(!Functions.LimitInOutValue()){
            Functions.Stop_extend();
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_timer.stop();
        m_timer.reset();
        done = true;
        Functions.Arm_extend(0);
        Functions.Stop_extend();
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}
