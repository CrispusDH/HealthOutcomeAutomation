package enums;

public class WriteAReviewEnums {

    public enum GenderOptions{
        MALE,
        FEMALE
    }

    public enum AgeOptions{
        LESS_EIGHTEEN,
        EIGHTEEN_TO_THIRTY_FOUR,
        THIRTY_FIVE_TO_FIFTY_FOUR,
        MORE_FIFTY_FIVE
    }

    public enum PhysicalActivityOptions{
        ZERO_TO_FOUR,
        FOUR_TO_EIGHT,
        MORE_EIGHT
    }

    public enum StatusOptions{
        IN_PAIN,
        RECOVERING,
        CURED
    }

    public enum PainInterfereOptions{
        NOT_AT_ALL,
        A_LITTLE_BIT,
        SOMEWHAT,
        QUITE_A_BIT,
        ALL_THE_TIME
    }

    public enum PainLevelOptions{
        NO_PAIN,
        MILD,
        DISCOMFORTING,
        DISTRESSING,
        HORRIBLE,
        EXCRUCIATING
    }

    public enum SufferedOptions{
        ZERO_TO_SIX,
        SIX_TO_EIGHTEEN,
        MORE_EIGHTEEN
    }

    public enum RepeatOptions{
        YES,
        NO
    }
}