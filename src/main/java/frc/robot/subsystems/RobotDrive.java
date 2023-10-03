package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class RobotDrive extends SubsystemBase {

    public final CANSparkMax m_FrontRightMotor = new CANSparkMax(RobotMap.DriveMap.frontRightCanId, MotorType.kBrushless);
    public final CANSparkMax m_FrontLeftMotor = new CANSparkMax(RobotMap.DriveMap.frontLeftCanId, MotorType.kBrushless);
    public final CANSparkMax m_BackRightMotor = new CANSparkMax(RobotMap.DriveMap.backRightCanId, MotorType.kBrushless);
    public final CANSparkMax m_BackLeftMotor = new CANSparkMax(RobotMap.DriveMap.backLeftCanId, MotorType.kBrushless);

    private final MotorControllerGroup m_leftmotors;
    private final MotorControllerGroup m_rightmotors;
  
  private final DifferentialDrive m_drive;

    public RobotDrive(){

        m_leftmotors = new MotorControllerGroup(
            m_BackLeftMotor, m_FrontLeftMotor);
      
          m_rightmotors = new MotorControllerGroup(
            m_BackRightMotor, m_FrontRightMotor);
      
          m_leftmotors.setInverted(RobotMap.DriveMap.leftInvert);
          m_rightmotors.setInverted(RobotMap.DriveMap.rightInvert);
      
          m_drive = new DifferentialDrive(m_leftmotors, m_rightmotors);
    }
    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_drive.tankDrive(leftSpeed, rightSpeed);
      }
}
