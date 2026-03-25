package mondayTwentyThreeAssessment.bike;

public class Bike {

    private boolean isTurnedOn;


    private int speed;

    private int gear;

    private final int GEAR_ONE = 1;
    private final int GEAR_TWO = 2;
    private final int GEAR_THREE = 3;
    private final int GEAR_FOUR = 4;






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
        if(this.speed < 0){
            this.speed = 0;
        }
        else{
        if(this.speed <= 20){
            this.speed += GEAR_ONE;
            if(speed > 20) gear = GEAR_TWO;

        }
        else if (this.speed <= 30){
            this.speed += GEAR_TWO;
            if(speed > 30) gear = GEAR_THREE;
        }
        else if (this.speed <= 40){
            this.speed += GEAR_THREE;
            if(speed > 40) gear = GEAR_FOUR;
        }else {
            this.speed += GEAR_FOUR;
        }
        }
    }

    public void decelerate(){
        if(this.speed < 0){
            this.speed = 0;
        }
        else{
            if(this.speed <= 20){
                this.speed -= GEAR_ONE;

            }
            else if (this.speed <= 30){
                this.speed -= GEAR_TWO ;
                if(speed <= 20) gear = GEAR_ONE;
            }
            else if (this.speed <= 40){
                this.speed -= GEAR_THREE;
                if(speed <= 30) gear = GEAR_TWO;
            }else {
                this.speed -= GEAR_FOUR;
                if(speed <= 40) gear = GEAR_THREE;
            }
        }
    }



}
