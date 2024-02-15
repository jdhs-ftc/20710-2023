package org.firstinspires.ftc.teamcode.vision;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
@Autonomous
public class ExampleVisionAuto extends LinearOpMode {
    TeamPropDeterminationPipeline teamPropPipeline;
    PipelineProcessor teamPropProcessor;
    TeamPropDeterminationPipeline.PropPosition position;

    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;



    @Override
    public void runOpMode() throws InterruptedException {
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "frontleft");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "backleft");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "frontright");
        rightBackDrive = hardwareMap.get(DcMotor.class, "backright");
        teamPropPipeline = new TeamPropDeterminationPipeline(true); //TODO: TRUE if blue side autonomous, FALSE if red side autonomous

        teamPropProcessor = new PipelineProcessor(teamPropPipeline);
        new VisionPortal.Builder()
                .setStreamFormat(VisionPortal.StreamFormat.MJPEG)
                .setCameraResolution(new Size(640,480))
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessors(teamPropProcessor)
                .enableLiveView(true)
                .build();

        while (!isStopRequested() && !isStarted()) {
            telemetry.addData("Position", teamPropPipeline.getAnalysis());
            telemetry.addData("Confidence", teamPropPipeline.getConfidence());
            telemetry.update();
        }

        position = teamPropPipeline.getAnalysis();

        switch (position) {
            case LEFT:
                //TODO:  Left side autonomous here


                break;
            case CENTER:
                //TODO: Center side autonomous here
                //set direction
                leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
                leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
                rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
                rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
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
                break;
            case RIGHT:
                //TODO: Right side autonomous here
                break;
        }


    }
}
