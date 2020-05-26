import java.util.HashMap;
import java.util.Map;

public class AStarState {
	
    private Map2D map;
    private HashMap<Location,Waypoint> cW = new HashMap<>();
    private HashMap<Location,Waypoint> oW = new HashMap<>();
    
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()
    {
    	if (this.numOpenWaypoints() == 0) return null;
    	Waypoint minCostWay = null;
        for (Waypoint element : oW.values())
        {
        	if (minCostWay == null) minCostWay = element;
        	if (element.getTotalCost()<minCostWay.getTotalCost()) minCostWay = element;
       }  	
       return minCostWay;
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Location loc = newWP.getLocation();
        if (oW.containsKey(loc))
        {
        	if (oW.get(loc).getPreviousCost()>newWP.getPreviousCost())
        	{
        		oW.put(loc, newWP);
        		return true;
        	}
        	else return false;
        }
        else
        {
    		oW.put(loc,newWP);
    		return true;
        }
    }


    public int numOpenWaypoints()
    {
        return this.oW.size();
    }


    public void closeWaypoint(Location loc)
    {
    	cW.put(loc, oW.get(loc));
    	oW.remove(loc);
    }

    public boolean isLocationClosed(Location loc)
    {
    	if (cW.containsKey(loc)) return true;
    	else return false;
    }
}
