// package frc.robot.subsystems;

// import edu.wpi.first.cscore.UsbCamera;
// import edu.wpi.first.cscore.VideoSink;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.*;

// public class CameraSubsystem extends SubsystemBase
// {
// private UsbCamera cam0 = null;
// private UsbCamera cam1 = null;

// private VideoSink server;
// private VideoSink server1;

// public CameraSubsystem()
// {
// this.cam0 = CameraServer.getInstance().startAutomaticCapture("usb0", 0);
// this.cam1 = CameraServer.getInstance().startAutomaticCapture("usb1", 1);
// this.server = CameraServer.getInstance().getServer("serve_usb0");
// this.server1 = CameraServer.getInstance().getServer("serve_usb1");

// usbCamera.setResolution(Constants.RESOLUTION[0], Constants.RESOLUTION[1]);
// usbCamera.setFPS(Constants.FRAMES_PER_SECOND);
// server.getProperty("compression").set(Constants.COMPRESSION);

// // If there are two feeds, declare and set values for two cameras.
// if (Constants.USING_TWO_CAMERAS == true)
// {
// this.cam0 = CameraServer.getInstance().startAutomaticCapture("usb0", 0);
// this.cam1 = CameraServer.getInstance().startAutomaticCapture("usb1", 1);
// this.server = CameraServer.getInstance().getServer("serve_usb0");
// this.server1 = CameraServer.getInstance().getServer("serve_usb1");
// this.server1.getProperty("compression").set(compression);
// }
// // If two feeds is false, only declare and set values for one camera
// else
// {
// this.cam0 = CameraServer.getInstance().startAutomaticCapture("usb0", 0);
// this.server = CameraServer.getInstance().getServer("serve_usb0");
// setCameraValues(width, height, FPS, compression, 2);
// this.server1.getProperty("compression").set(compression);
// }
// }

// // public void switchCamera(VideoSink server, UsbCamera source)
// // {
// // server.setSource(source);
// // }

// public void switchCamera()
// {
// if (this.cam1 != null)
// {
// if (this.cam0.isEnabled())
// {
// this.server.setSource(this.cam1);
// }
// else
// {
// this.server.setSource(this.cam0);
// }
// }
// }

// @Override
// public void periodic()
// {
// // This block of code runs once per schedular 'tick'
// // Pretty much do nothing in this section
// }

// }