package mondayTwentyThreeAssessment.ac;

public class AirConditioner {

    private boolean isOn;
    private int temperature;
    private int fanSpeed; //
    private String mode; //

    // Power controls
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    // Temperature controls
    public void setTemperature(int temperature) {
        if (isOn && temperature >= 16 && temperature <= 30) {
            this.temperature = temperature;
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        if (isOn && temperature < 30) {
            temperature++;
        }
    }

    public void decreaseTemperature() {
        if (isOn && temperature > 16) {
            temperature--;
        }
    }

    // Fan speed controls
    public void setFanSpeed(int fanSpeed) {
        if (isOn && fanSpeed >= 1 && fanSpeed <= 5) {
            this.fanSpeed = fanSpeed;
        }
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void increaseFanSpeed() {
        if (isOn && fanSpeed < 5) {
            fanSpeed++;
        }
    }

    public void decreaseFanSpeed() {
        if (isOn && fanSpeed > 1) {
            fanSpeed--;
        }
    }


    public void setMode(String mode) {
        if (isOn && (mode.equals("cool") || mode.equals("heat") || mode.equals("fan") || mode.equals("dry"))) {
            this.mode = mode;
        }
    }

    public String getMode() {
        return mode;
    }
}