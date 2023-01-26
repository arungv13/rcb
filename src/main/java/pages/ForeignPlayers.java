package pages;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ForeignPlayers {
    Logger log = Logger.getLogger(WicketKeepers.class);
    public int getForeignPlayersCount(JSONObject jsonData) {
        try {
            int foreignPlayerCount = 0;
            JSONArray arrayData = (JSONArray) jsonData.get("player");
            for (Object arrayDatum : arrayData) {
                JSONObject player = (JSONObject) arrayDatum;
                if (!player.get("country").equals("India")) {
                    foreignPlayerCount++;
                }
            }
            log.info("************Method 'getForeignPlayersCount' executed, and returned the value: " + foreignPlayerCount + "************");
            return foreignPlayerCount;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }
}