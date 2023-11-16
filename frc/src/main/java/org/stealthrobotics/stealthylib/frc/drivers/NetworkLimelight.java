package org.stealthrobotics.stealthylib.frc.drivers;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NetworkLimelight {

    // Reflective Tape Tracking
    private final NetworkTableEntry
            tv,
            tx,
            ty,
            ta,
            tl,
            cl,
            tshort,
            tlong,
            thor,
            tvert,
            getpipe,
            json,
            tclass,
            tc;

    // Fiducial Tracking
    private final NetworkTableEntry
            botpose,
            botpose_wpiblue,
            botpose_wpired,
            camerapose_targetspace,
            targetpose_cameraspace,
            targetpose_robotspace,
            botpose_targetspace,
            camerapose_robotspace,
            tid;

    // Camera Controls
    private final NetworkTableEntry
            ledMode,
            camMode,
            pipeline,
            stream,
            snapshot,
            crop,
            camerapose_robotspace_set;

    public NetworkLimelight() {
        this("limelight");
    }

    public NetworkLimelight(String name) {
        NetworkTable table = NetworkTableInstance.getDefault().getTable(name);

        // Reflective Tape Tracking
        tv = table.getEntry("tv");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tl = table.getEntry("tl");
        cl = table.getEntry("cl");
        tshort = table.getEntry("tshort");
        tlong = table.getEntry("tlong");
        thor = table.getEntry("thor");
        tvert = table.getEntry("tvert");
        getpipe = table.getEntry("getpipe");
        json = table.getEntry("json");
        tclass = table.getEntry("tclass");
        tc = table.getEntry("tc");

        // Fiducial Tracking
        botpose = table.getEntry("botpose");
        botpose_wpiblue = table.getEntry("botpose_wpiblue");
        botpose_wpired = table.getEntry("botpose_wpired");
        camerapose_targetspace = table.getEntry("camerapose_targetspace");
        targetpose_cameraspace = table.getEntry("targetpose_cameraspace");
        targetpose_robotspace = table.getEntry("targetpose_robotspace");
        botpose_targetspace = table.getEntry("botpose_targetspace");
        camerapose_robotspace = table.getEntry("camerapose_robotspace");
        tid = table.getEntry("tid");

        // Camera Controls
        ledMode = table.getEntry("ledMode");
        camMode = table.getEntry("camMode");
        pipeline = table.getEntry("pipeline");
        stream = table.getEntry("stream");
        snapshot = table.getEntry("snapshot");
        crop = table.getEntry("crop");
        camerapose_robotspace_set = table.getEntry("camerapose_robotspace_set");
    }

    // Reflective Tape Tracking
    public boolean getTv_Reflective() {
        return tv.getBoolean(false);
    }

    public boolean hasTarget_Reflective() {
        return getTv_Reflective();
    }

    public double getTx_Reflective() {
        return tx.getDouble(0.0);
    }

    public double getTargetHorizontalOffsetFromCenter_Reflective() {
        return getTx_Reflective();
    }

    public double getTy_Reflective() {
        return ty.getDouble(0.0);
    }

    public double getTargetVerticalOffsetFromCenter_Reflective() {
        return getTy_Reflective();
    }

    public double getTa_Reflective() {
        return ta.getDouble(0.0);
    }

    public double getTargetArea_Reflective() {
        return getTa_Reflective();
    }

    public double getTl_Reflective() {
        return tl.getDouble(0.0);
    }

    public double getPipelineLatency_Reflective() {
        return getTl_Reflective();
    }

    public double getCl_Reflective() {
        return cl.getDouble(0.0);
    }

    public double getCaptureLatency_Reflective() {
        return getCl_Reflective();
    }

    public double getTshort_Reflective() {
        return tshort.getDouble(0.0);
    }

    public double getTargetBoundingBoxShortSideLength_Reflective() {
        return getTshort_Reflective();
    }

    public double getTlong_Reflective() {
        return tlong.getDouble(0.0);
    }

    public double getTargetBoundingBoxLongSideLength_Reflective() {
        return getTlong_Reflective();
    }

    public double getThor_Reflective() {
        return thor.getDouble(0.0);
    }

    public double getTargetBoundingBoxHorizontalSideLength_Reflective() {
        return getThor_Reflective();
    }

    public double getTvert_Reflective() {
        return tvert.getDouble(0.0);
    }

    public double getTargetBoundingBoxVerticalSideLength_Reflective() {
        return getTvert_Reflective();
    }

    public double getGetpipe_Reflective() {
        return getpipe.getDouble(0.0);
    }

    public double getPipelineIndex_Reflective() {
        return getGetpipe_Reflective();
    }

    public String getJson_Reflective() {
        return json.getString("");
    }

    public String getJsonDump_Reflective() {
        return getJson_Reflective();
    }

    public double getTclass_Reflective() {
        return tclass.getDouble(0.0);
    }

    public double getPrimaryNeuralDetectorClassID_Reflective() {
        return getTclass_Reflective();
    }

    public double[] getTc_Reflective() {
        return tc.getDoubleArray(new double[]{});
    }

    public double[] getAverageHSVUnderCrosshair() {
        return getTc_Reflective();
    }

    // Fiducial Tracking

    public double[] getBotpose_Fiducial() {
        return botpose.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getBotPoseAsPose3d_Fiducial() {
        double[] pose = getBotpose_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getBotpose_wpiblue_Fiducial() {
        return botpose_wpiblue.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getBotPoseWPIBlueAsPose3d() {
        double[] pose = getBotpose_wpiblue_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getBotpose_wpired_Fiducial() {
        return botpose_wpired.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getBotPoseWPIRedAsPose3d_Fiducial() {
        double[] pose = getBotpose_wpired_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getCamerapose_targetspace_Fiducial() {
        return camerapose_targetspace.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getCameraPoseTargetSpaceAsPose3d_Fiducial() {
        double[] pose = getCamerapose_targetspace_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getTargetpose_cameraspace_Fiducial() {
        return targetpose_cameraspace.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getTargetPoseCameraSpaceAsPose3d() {
        double[] pose = getTargetpose_cameraspace_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getTargetpose_robotspace_Fiducial() {
        return targetpose_robotspace.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getTargetPoseRobotSpaceAsPose3d() {
        double[] pose = getTargetpose_robotspace_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getBotpose_targetspace_Fiducial() {
        return botpose_targetspace.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getBotPoseTargetSpaceAsPose3d_Fiducial() {
        double[] pose = getBotpose_targetspace_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double[] getCamerapose_robotspace_Fiducial() {
        return camerapose_robotspace.getDoubleArray(new double[]{0.0 , 0.0, 0.0, 0.0, 0.0, 0.0});
    }

    public Pose3d getCameraPoseRobotSpaceAsPose3d_Fiducial() {
        double[] pose = getCamerapose_robotspace_Fiducial();
        return new Pose3d(pose[0], pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]));
    }

    public double getTid_Fiducial() {
        return tid.getDouble(0.0);
    }

    public double getTargetID_Fiducial() {
        return getTid_Fiducial();
    }

    // Camera Controls

    public enum LED_MODE {
        PIPELINE(0),
        OFF(1),
        BLINK(2),
        ON(3);

        private final int value;

        LED_MODE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean setLedMode_Control(int mode) {
        return ledMode.setNumber(mode);
    }

    public boolean setLedMode_Control(LED_MODE mode) {
        return setLedMode_Control(mode.getValue());
    }

    public LED_MODE getLedMode_Control() {
        return LED_MODE.values()[(int) ledMode.getDouble(0.0)];
    }

    public enum CAM_MODE {
        VISION_PROCESSOR(0),
        DRIVER_CAMERA(1);

        private final int value;

        CAM_MODE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean setCamMode_Control(int mode) {
        return camMode.setNumber(mode);
    }

    public boolean setCamMode_Control(CAM_MODE mode) {
        return setCamMode_Control(mode.getValue());
    }

    public CAM_MODE getCamMode_Control() {
        return CAM_MODE.values()[(int) camMode.getDouble(0.0)];
    }

    public boolean setPipeline_Control(int pipeline) {
        return this.pipeline.setNumber(pipeline);
    }

    public int getPipeline_Control() {
        return (int) pipeline.getDouble(0.0);
    }

    public enum STREAM_MODE {
        STANDARD(0),
        PIP_MAIN(1),
        PIP_SECONDARY(2);

        private final int value;

        STREAM_MODE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean setStream_Control(int mode) {
        return stream.setNumber(mode);
    }

    public boolean setStream_Control(STREAM_MODE mode) {
        return setStream_Control(mode.getValue());
    }

    public STREAM_MODE getStream_Control() {
        return STREAM_MODE.values()[(int) stream.getDouble(0.0)];
    }

    public enum SNAPSHOT_MODE {
        RESET(0),
        CAPTURE(1);

        private final int value;

        SNAPSHOT_MODE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean setSnapshot_Control(int mode) {
        return snapshot.setNumber(mode);
    }

    public boolean setSnapshot_Control(SNAPSHOT_MODE mode) {
        return setSnapshot_Control(mode.getValue());
    }

    public SNAPSHOT_MODE getSnapshot_Control() {
        return SNAPSHOT_MODE.values()[(int) snapshot.getDouble(0.0)];
    }

    public boolean setCrop_Control(double[] crop) {
        return this.crop.setDoubleArray(crop);
    }

    public double[] getCrop_Control() {
        return crop.getDoubleArray(new double[]{});
    }

    public boolean setCameraPoseRobotSpace_Control(double[] pose) {
        return camerapose_robotspace_set.setDoubleArray(pose);
    }

    public boolean setCameraPoseRobotSpace_Control(Pose3d pose) {
        return setCameraPoseRobotSpace_Control(new double[]{pose.getTranslation().getX(), pose.getTranslation().getY(), pose.getTranslation().getZ(), pose.getRotation().getX(), pose.getRotation().getY(), pose.getRotation().getZ()});
    }

    public double[] getCameraPoseRobotSpace_Control() {
        return camerapose_robotspace_set.getDoubleArray(new double[]{});
    }
}
