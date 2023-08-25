package frc.robot.subsystems;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class CameraSubsystem extends SubsystemBase
    {

    public CameraSubsystem()
        {
        }

    public void setCameraValues(UsbCamera usbCamera, VideoSink server)
    {
        usbCamera.setResolution(CameraConstants.resolution[0],
                CameraConstants.resolution[1]);
        usbCamera.setFPS(CameraConstants.framesPerSecond);
        server.getProperty("compression").set(CameraConstants.compression);
    }

    public void switchCamera(VideoSink server, UsbCamera desiredSource)
    {
        if (CameraConstants.USING_TWO_CAMERAS)
            {
            server.setSource(desiredSource);
            }
    }

    }
