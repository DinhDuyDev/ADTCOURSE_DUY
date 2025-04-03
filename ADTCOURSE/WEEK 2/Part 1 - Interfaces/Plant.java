/**
 * Interface for a Plant. Specifies the behaviors that all plants
 * must implement.
 * @author Anna Rafferty
 *
 */
public interface Plant {
    /**
     * Returns the name of the plant. 
     * @return String representing plant's name
     */
    public String getName();
    
    /**
     * Waters the plant with unitsWater water.
     * @param unitsWater number of units of water the plant receives
     */
    public void waterPlant(int unitsWater);
    
    /**
     * Ages the plant by a day. This could change the 
     * plant's water level or other characteristics.
     */
    public void elapseDay();
    
    /** 
     * Returns a string describing the state of the plant. E.g., might say "overly dry" or 
     * "abundantly happy". State of the plant may vary with water level or other
     * characteristics.
     * @return String representing status
     */
    public String getStatus();
    
    /** 
     * Returns the current water level for the plant. Each plant has a water level indicating 
     * whether it is dry, water-logged, or somewhere in between. 
     * @return int representing water level
     */
    public int getWaterLevel();
    

}
