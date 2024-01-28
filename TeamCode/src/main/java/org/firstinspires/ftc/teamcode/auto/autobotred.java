// we want one autop mode for each of the 4 pos
// 1 is leftblue 2 is rightblue 3 leftred 4 rightred
//move forward to park pixel on strip
//move back almost same amount to go to start position. then go to the right.

//move forward to park pixel on strip
//move back almost same amount to go to start position.
//then go to the right.
package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;



@Autonomous(name="autobotred", group="Linear OpMode")

public class autobotred extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;



    @Override
    public void runOpMode() {
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "frontleft");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "backleft");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "frontright");
        rightBackDrive = hardwareMap.get(DcMotor.class, "backright");
        //set direction
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        //drive forward
        leftBackDrive.setPower(.4);
        leftFrontDrive.setPower(.4);
        rightBackDrive.setPower(.4);
        rightFrontDrive.setPower(.4);
        sleep(1000);
        //stop robot, let motors wind down.
        leftBackDrive.setPower(0);
        leftFrontDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        sleep(500);
        //moving backwards
        leftBackDrive.setPower(-.5);
        leftFrontDrive.setPower(-.5);
        rightFrontDrive.setPower(-.5);
        rightBackDrive.setPower(-.5);
        sleep(900);
        leftBackDrive.setPower(0);
        leftFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        sleep(100);


    }
}
