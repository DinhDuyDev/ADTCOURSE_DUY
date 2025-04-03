public class Carrot implements Plant {
    private static final int DROUGHT_LEVEL = -8;
    private static final int FLOOD_LEVEL = 6;
    private static final int IDEAL_LEVEL = -2;
    private static final int LIFE_SPAN = 15;
    private int waterLevel;
    private int age;
    private boolean hasExperiencedDrought;
    private String name;
 
    public Carrot() {
       this("Carrot");
    }
 
    public Carrot(String var1) {
       this.waterLevel = 0;
       this.age = 0;
       this.hasExperiencedDrought = false;
       this.name = var1;
    }
 
    public String getName() {
       return this.name;
    }
 
    public void waterPlant(int var1) {
       this.waterLevel += var1;
    }
 
    public void elapseDay() {
       ++this.age;
       --this.waterLevel;
       if (this.waterLevel <= -8) {
          this.hasExperiencedDrought = true;
       }
 
    }
 
    public String getStatus() {
       if (this.age > 15) {
          return "composted";
       } else if (this.hasExperiencedDrought) {
          return "split from drought";
       } else if (this.waterLevel > 6) {
          return "drowning!";
       } else if (this.waterLevel == -2) {
          return "deliriously happy";
       } else {
          return this.getDistanceFromIdeal() < 3 ? "growing happily" : "okay";
       }
    }
 
    private int getDistanceFromIdeal() {
       return Math.abs(this.waterLevel - -2);
    }
 
    public int getWaterLevel() {
       return this.waterLevel;
    }
 }
 