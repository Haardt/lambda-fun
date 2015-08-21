package de.iritgo.lambda.configuration;

import java.io.IOException;

@FunctionalInterface
public interface Config {
    void eval (SystemConfig systemConfig) throws IOException;
}
