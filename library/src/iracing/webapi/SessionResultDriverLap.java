package iracing.webapi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class SessionResultDriverLap {
    
    private int lapNumber;
    private long lapTime;
    private int flags;
    private String flagsText;
    
    public SessionResultDriverLap() {}

    public String getFlagsText() {
        if (flagsText == null) generateFlagsText();
        return flagsText;
    }
    
    private void generateFlagsText() {
        List<String> output = new ArrayList<String>();
        if (getInvalid()) output.add("invalid");
        if (getPitted()) output.add("pitted");
        if (getOffTrack()) output.add("off track");
        if (getBlackFlag()) output.add("black flag");
        if (getCarReset()) output.add("car reset");
        if (getContact()) output.add("contact");
        if (getCarContact()) output.add("car contact");
        if (getLostControl()) output.add("lost control");
        if (getDiscontinuity()) output.add("discontinuity");
        if (getInterpolatedCrossing()) output.add("interpolated crossing");
        if (getClockSmash()) output.add("clock smash");
        if (getTow()) output.add("tow");
        StringBuilder sb = new StringBuilder();
        for (String s : output) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(s);
        }
        flagsText = sb.toString();
    }
    
    public boolean getInvalid() {
        return (flags & 1) == 1;
    }
    
    public boolean getPitted() {
        return (flags & 2) == 2;
    }
    
    public boolean getOffTrack() {
        return (flags & 4) == 4;
    }
    
    public boolean getBlackFlag() {
        return (flags & 8) == 8;
    }
    
    public boolean getCarReset() {
        return (flags & 16) == 16;
    }
    
    public boolean getContact() {
        return (flags & 32) == 32;
    }
    
    public boolean getCarContact() {
        return (flags & 64) == 64;
    }
    
    public boolean getLostControl() {
        return (flags & 128) == 128;
    }
    
    public boolean getDiscontinuity() {
        return (flags & 256) == 256;
    }
    
    public boolean getInterpolatedCrossing() {
        return (flags & 512) == 512;
    }
    
    public boolean getClockSmash() {
        return (flags & 1024) == 1024;
    }
    
    public boolean getTow() {
        return (flags & 2048) == 2048;
    }
    
    public int getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }

    public long getLapTime() {
        return lapTime;
    }

    public void setLapTime(long lapTime) {
        this.lapTime = lapTime;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
    
}