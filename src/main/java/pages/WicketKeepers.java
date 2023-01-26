package pages;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WicketKeepers {
    Logger log = Logger.getLogger(WicketKeepers.class);

    public int getWicketKeepersCount(JSONObject jsonData) {
        try {
            int wicketKeeperCount = 0;
            JSONArray arrayData = (JSONArray) jsonData.get("player");
            for (int i = 0; i < arrayData.size(); i++) {
                JSONObject player = (JSONObject) arrayData.get(i);
                if (player.get("role").equals("Wicket-keeper")) {
                    wicketKeeperCount++;
                }
            }
            log.info("************Method 'getWicketKeepersCount' executed, and returned the value: " + wicketKeeperCount + "************");
            return wicketKeeperCount;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }
}