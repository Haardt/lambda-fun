package de.iritgo.lambda;

import de.iritgo.lambda.configuration.Config;
import de.iritgo.lambda.configuration.SystemConfig;

import java.io.IOException;

public class Configure {
    public static SystemConfig systemConfig(Config config) {
        try {
            SystemConfig systemConfig = new SystemConfig();
            config.eval(systemConfig);
            return systemConfig;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
