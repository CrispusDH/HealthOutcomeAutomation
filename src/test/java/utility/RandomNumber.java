package utility;


//create random number
public class RandomNumber {

    private static int randomNumber = 0;

    public static int createRandomNumber(int Min, int Max){

        return randomNumber = Min + (int)(Math.random() * ((Max - Min) + 1));

    }

    public static int currentRandomNumber(){
        return randomNumber;
    }
}
