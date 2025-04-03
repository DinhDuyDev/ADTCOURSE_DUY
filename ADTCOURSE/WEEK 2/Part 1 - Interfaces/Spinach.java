public class Spinach implements Plant {
    private static final int DROUGHT_WLEVEL = -10;
    private static final int HEALTHY_WLEVEL = 5;
    private static final int FLOOD_WLEVEL = 15;
    private static final int MUTATION_LEVEL = 20;

    private String name;
    private int waterLevel = 2;
    private String status;
    private int age = 0; 

    public Spinach() {
        this.name = "Spinach";
    }
    /**
     * Returns the name of the plant. 
     * @return String representing plant's name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Waters the plant with unitsWater water.
     * @param unitsWater number of units of water the plant receives
     */
    public void waterPlant(int unitsWater) {
        this.waterLevel ++;
    }
    
    /**
     * Ages the plant by a day. This could change the 
     * plant's water level or other characteristics.
     */
    public void elapseDay() {
        this.age++;
        this.waterLevel--;
    }
    
    /** 
     * Returns a string describing the state of the plant. E.g., might say "overly dry" or 
     * "abundantly happy". State of the plant may vary with water level or other
     * characteristics.
     * @return String representing status
     */
    public String getStatus() {
        this.changeStatus();
        return this.status;
    }
    
    /** 
     * Returns the current water level for the plant. Each plant has a water level indicating 
     * whether it is dry, water-logged, or somewhere in between. 
     * @return int representing water level
     */
    public int getWaterLevel() {
        return this.waterLevel;
    }

    private void changeStatus() {
        if (waterLevel <= DROUGHT_WLEVEL) {
            this.status = "PLANT_STATUS: INSUFFICIENT TO KEEP ALIVE;";
        } else if (waterLevel <= HEALTHY_WLEVEL && waterLevel > DROUGHT_WLEVEL) {
            this.status = "PLANT_STATUS: SUFFICIENT TO KEEP ALIVE;";
        } else if (waterLevel <= FLOOD_WLEVEL && waterLevel > HEALTHY_WLEVEL) {
            this.status = "PLANT_STATUS: NEARLY DYING;";
        } else if (waterLevel == MUTATION_LEVEL) {
            this.status = "PLANT_STATUS: MUTATION. LIFESPAN ROSE DRAMATICALLY;";
        } else if (waterLevel > MUTATION_LEVEL) {
            this.status = "PLANT_STATUS: PLANT IS CRUSHED UNDER WEIGHT OF WATER;";
        }
    }

    public static void main(String[] args) {
        Plant newSpinach = new Spinach();
        newSpinach.elapseDay();
        for (int i=0; i<19; i++) {
            newSpinach.waterPlant(1);
        }
        System.out.println(newSpinach.getStatus());
        System.out.println("PLANT_WLEVEL:" + newSpinach.getWaterLevel());
    }
}