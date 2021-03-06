package org.usfirst.frc.team2791.robot.subsystems;

import org.usfirst.frc.team2791.util.Constants;
import org.usfirst.frc.team2791.util.ShakerGyro;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShakerDrivetrain extends Subsystem{
	
	protected Encoder leftDriveEncoder = null;
	protected Encoder rightDriveEncoder = null;
	
	protected ShakerGyro gyro;
	
	protected RobotDrive shakyDrive = null;

    private Talon leftTalonA;
    private Talon leftTalonB;
    private Talon leftTalonC;
    
    private Talon rightTalonA;
    private Talon rightTalonB;
    private Talon rightTalonC;
    
	public void initDefaultCommand() {
		//is there where I declare a drivetrain or will it reset a drivetrain every single time?
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
		this.leftTalonA = new Talon(Constants.DRIVE_TALON_LEFT_PORT_FRONT);
        this.leftTalonB = new Talon(Constants.DRIVE_TALON_LEFT_PORT_BACK);
        this.leftTalonC = new Talon(Constants.DRIVE_TALON_LEFT_PORT_C);

        this.rightTalonA = new Talon(Constants.DRIVE_TALON_RIGHT_PORT_FRONT);
        this.rightTalonB = new Talon(Constants.DRIVE_TALON_RIGHT_PORT_BACK);
        this.rightTalonC = new Talon(Constants.DRIVE_TALON_RIGHT_PORT_C);

        this.leftDriveEncoder = new Encoder(Constants.LEFT_DRIVE_ENCODER_PORT_A, Constants.LEFT_DRIVE_ENCODER_PORT_B);
        this.rightDriveEncoder = new Encoder(Constants.RIGHT_DRIVE_ENCOODER_PORT_A,
                Constants.RIGHT_DRIVE_ENCODER_PORT_B);
        
        // use the talons to create a roboDrive (it has methods that allow for easier control)
        this.shakyDrive = new RobotDrive(new TalonSet(leftTalonA, leftTalonB, leftTalonC),
                new TalonSet(rightTalonA, rightTalonB, rightTalonC));
        //robotDrive = new RobotDrive(leftTalonA, leftTalonB, rightTalonA, rightTalonB);
        // stop all motors right away just in case
        shakyDrive.stopMotor();

		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
		
		leftDriveEncoder.setDistancePerPulse(Util.tickToFeet(driveEncoderTicks, Constants.WHEEL_DIAMETER)); 
		rightDriveEncoder.setDistancePerPulse(-Util.tickToFeet(driveEncoderTicks, Constants.WHEEL_DIAMETER)); 

		gyro = new ShakerGyro(SPI.Port.kOnboardCS1);
		(new Thread(gyro)).start();
		
	}
	

	public void forward(double distance) {
		
	}
	
	public void left(double distance) {
		
	}
	
	public void right(double distance) {
		
	}
	
	public void back(double distance) {
		
	}
	
}
