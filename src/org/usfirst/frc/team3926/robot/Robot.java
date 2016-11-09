
package org.usfirst.frc.team3926.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;


public class Robot extends IterativeRobot {
	
	static final int ARM_ACTIVATE_BUTTON = 6; 
	
	CANTalon talonSRX_FR;
	CANTalon talonSRX_FL;
	CANTalon talonSRX_BR;
	CANTalon talonSRX_BL;
	CANTalon talonSRX_arm1;
	CANTalon talonSRX_arm2;
	CANTalon talonSRX_arm1down;
	CANTalon talonSRX_arm2down;
	CANTalon talonSRX_wheels;
	
	RobotDrive driveSystem;                                                             
	
	Joystick leftStick;
	Joystick rightStick;
	
	
    public void robotInit() {
    	
    	talonSRX_FR = new CANTalon(0);
    	talonSRX_FL = new CANTalon(1);
    	talonSRX_BR = new CANTalon(2);
    	talonSRX_BL = new CANTalon(3);
    	talonSRX_arm1 = new CANTalon(4);
    	talonSRX_arm2 = new CANTalon(5);
    	talonSRX_wheels = new CANTalon(6);
    	talonSRX_arm1down = new CANTalon(7);
    	talonSRX_arm2down = new CANTalon(8);
    	
    	driveSystem = new RobotDrive(talonSRX_FR, talonSRX_FL, talonSRX_BR, talonSRX_BL);
    	
    	leftStick = new Joystick(0);
    	rightStick = new Joystick(1);
    	
    	
    }
      
    public void teleopPeriodic() {
    	
    	double leftStickValue = leftStick.getY();
    	double rightStickValue = rightStick.getY();  

    	
    	if (leftStick.getRawButton(1)){
    		
    		leftStickValue /= 2;
    		rightStickValue /= 2;
    	}
    	
    	if(rightStick.getRawButton(1)){
    		
    		leftStickValue = rightStickValue;
    	}
    	
    	 if (rightStick.getRawButton(3)){
         	leftStickValue = rightStickValue /= 2;
         }  
         
         if (leftStick.getRawButton(2)){
         	rightStickValue = leftStickValue /= 2;
         	
         }
        
         
         if (rightStick.getRawButton(4)){
        	 
        	 talonSRX_arm1.set(.5); 
        	 
         } else {
        	 
        	 talonSRX_arm1.set(0); 	 
      
         } 
        	 
         
         if (leftStick.getRawButton(5)){
        	 
        	 talonSRX_arm2.set(.5); 
        	 
         } else {
        	 
        	 talonSRX_arm2.set(0);
        	 
        	 }
         
         
         if (rightStick.getRawButton(7)){
        	 
        	 talonSRX_arm1.set(-.5);
        	 
         } else {
        	 
        	 talonSRX_arm1.set(0);
         }
         
         
         if (leftStick.getRawButton(8)){
        	 
        	 talonSRX_arm2.set(-.5);
        	 
         } else {
        	 
        	 talonSRX_arm2.set(0);
        	 
        	 }
         
         
         if (rightStick.getRawButton(6)) { //Make all the other if statements look like this
        	 
        	 talonSRX_wheels.set(.5);
        	 
         } else {
        	 
        	 talonSRX_wheels.set(0);
        	 
         }
    	
    	
    	driveSystem.tankDrive(leftStickValue, rightStickValue);
    	
       
    } 
       
}

