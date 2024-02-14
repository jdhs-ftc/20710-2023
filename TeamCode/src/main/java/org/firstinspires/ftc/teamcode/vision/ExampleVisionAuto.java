package org.firstinspires.ftc.teamcode.vision;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

public class ExampleVisionAuto extends LinearOpMode {
    TeamPropDeterminationPipeline teamPropPipeline;
    PipelineProcessor teamPropProcessor;
    TeamPropDeterminationPipeline.PropPosition position;


    @Override
    public void runOpMode() throws InterruptedException {
        teamPropPipeline = new TeamPropDeterminationPipeline(true); //TODO: TRUE if blue side autonomous, FALSE if red side autonomous

        teamPropProcessor = new PipelineProcessor(teamPropPipeline);
        new VisionPortal.Builder()
                .setStreamFormat(VisionPortal.StreamFormat.MJPEG)
                .setCameraResolution(new Size(640,480))
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessors(teamPropProcessor)
                .enableLiveView(true)
                .build();

        while (opModeInInit() && opModeIsActive()) {
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
                break;
            case RIGHT:
                //TODO: Right side autonomous here
                break;
        }


    }
}
