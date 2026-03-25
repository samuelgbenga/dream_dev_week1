package mondayTwentyThreeAssessment.bike;

public class Bike {

    private boolean isTurnedOn;


    private int speed;

    private int gear;




    public void setIsTurnedOnToOn() {
        isTurnedOn = true;

    }

    public void setIsTurnedOnToOff() {
        isTurnedOn = false;
    }

    public boolean getIsTurnedOn(){
        return isTurnedOn;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }


    public void accelerate(){

    }

    public void decelerate(){

    }



}
