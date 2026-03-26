package mondayTwentyThreeAssessment.television;

public class Television {

    private boolean isOn;
    private int volume;
    private int channel;


    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }


    public void setVolume(int volume) {
        if (volume >= 0) {
            this.volume = volume;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void increaseVolume() {
        if (isOn) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (isOn && volume > 0) {
            volume--;
        }
    }


    public void setChannel(int channel) {
        if (isOn && channel > 0) {
            this.channel = channel;
        }
    }

    public int getChannel() {
        return channel;
    }

    public void nextChannel() {
        if (isOn) {
            channel++;
        }
    }

    public void previousChannel() {
        if (isOn && channel > 1) {
            channel--;
        }
    }
}