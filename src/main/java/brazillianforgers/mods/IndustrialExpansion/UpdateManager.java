package brazillianforgers.mods.IndustrialExpansion;

import java.io.IOException;
import java.net.URL;
import org.apache.logging.log4j.Logger;
import brazillianforgers.lib.StringHelper;

public final class UpdateManager {
    public enum UpdateStatus {
        UPDATED(true, true), OUTDATED(true, false), CANTCONNECT(false, true);

        public boolean connected;
        public boolean updated;
        public String version = null;

        UpdateStatus(boolean connected, boolean updated) {
            this.connected = connected;
            this.updated = updated;
        }

        public UpdateStatus setVersion(String version) {
            this.version = version;
            return this;
        }
    }

    private static String getNewestVersion(Logger logger, String updateUrl) {
        try {
            return StringHelper.getStringFromURL(new URL(updateUrl));
        } catch (IOException e) {
            logger.error("Could not connect to Remote: ", e);
        }
        return null;
    }

    /**
     * Let's Check for Updates!
     *
     * @param updateUrl      Update URL for getting the Latest Version.
     * @param logger         Mod Logger for Log Info into the Console.
     * @param currentVersion Current Version String
     * @param modName        Mod Name
     * @return Info about the Update Status
     */
    public static UpdateStatus check(String updateUrl, Logger logger, String currentVersion, String modName) {
        String newestVersion = getNewestVersion(logger, updateUrl);

        if (newestVersion == null) {
            logger.warn("Failed to connect to check if update is available.");
            return UpdateStatus.CANTCONNECT;
        }

		/* Nice little Fix for removing Tabs and New Lines */
        newestVersion = newestVersion.replaceAll("[\\\t|\\\n|\\\r]", "");

        if (newestVersion.equalsIgnoreCase(currentVersion)) {
            logger.info("The mod is updated.");
            return UpdateStatus.UPDATED;
        }

        logger.info("The mod is is outdated. You are running version: " + currentVersion + " and the latest available version is: " + newestVersion);
        return UpdateStatus.OUTDATED.setVersion(newestVersion);

    }
}
