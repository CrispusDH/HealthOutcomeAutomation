package enums;

public enum ConditionTabsEnum {

    TREATMENT_RATINGS("TREATMENT RATINGS"),
    TREATMENT_REVIEWS("TREATMENT REVIEWS"),
    VIDEOS_AND_GUIDES("VIDEOS & GUIDES");

    private String sConditionName;

    private ConditionTabsEnum(String sConditionName){
        this.sConditionName = sConditionName;
    }

    public String getsConditionName(){
        return sConditionName;
    }

}
