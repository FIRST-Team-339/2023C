package frc.robot.commands;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;

public class Camera extends CommandBase
    {
    // Subsystem
    private CameraSubsystem cameraSubsystem;

    // USB Cameras
    private UsbCamera camera0;
    private UsbCamera camera1;

    // USB Camera Servers
    private VideoSink server;

    public Camera(CameraSubsystem cameraSubsystem, boolean usingTwoCameras)
        {
            this.cameraSubsystem = cameraSubsystem;

            this.camera0 = CameraServer.startAutomaticCapture("Camera", 0);
            this.server = CameraServer.getServer("serve_Camera");
            cameraSubsystem.setCameraValues(camera0, server);

            // If `usingTwoCameras` is true, then start up the second server
            if (usingTwoCameras == true)
                {
                this.camera1 = new UsbCamera("Camera2", 1);
                cameraSubsystem.setCameraValues(camera1, server);
                }

        }

    @Override
    public void execute()
    {
        /**
         * Checks if camera 0 is enabled, and if so, switch the camera server to
         * display the second camera
         * 
         * Otherwise, switch the camera server to display the first camera
         */
        if (camera0.isEnabled() == true)
            {
            cameraSubsystem.switchCamera(server, camera1);
            }
        else
            {
            cameraSubsystem.switchCamera(server, camera0);
            }

        // Ends the command, as we have switched cameras!
        cancel();
    }
    }
