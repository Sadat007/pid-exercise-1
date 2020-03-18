
/**
 * Purpose of this class to store information about the protein bar.
 */

public class Bar {

    private String name;
    private double fat;
    private double energy;
    private double kolhydrat;
    private double protein;
    private double fiber;
    private int reviewerCount;

    public Bar(String name, double fat, double energy, double kolhydrat, double protein, double fiber, int reviewerCount) {
        this.fat = fat;
        this.name = name;
        this.energy = energy;
        this.kolhydrat = kolhydrat;
        this.protein = protein;
        this.fiber = fiber;
        this.reviewerCount = reviewerCount;
    }

    public String getName(){
        String returnName = name + "\t\t Energy :  " + energy  + "\t\tKolhydrat : " + kolhydrat  + "\t\tProtein :" + protein  + "\t\t Fiber : " + fiber +
                "\t\t Fat : " + fat + "\t\t ReviewerCount : " + reviewerCount;
        return returnName;
    }

    public Double getProtein()
    {
        return protein;
    }

    public Double getFat()
    {
        return fat;
    }

    public Double getFiber()
    {
        return fiber;
    }

    public int getReviewerCount(){
        return reviewerCount;
    }


}