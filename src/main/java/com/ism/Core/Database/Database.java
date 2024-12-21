package com.ism.Core.Database;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class Database {

    public static String getActiveDatabase(String key, String key2) {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = Database.class.getResourceAsStream("/database.yml")) {
            Map<String, Object> config = yaml.load(inputStream);
            return (String) ((Map<String, Object>) config.get(key)).get(key2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   
}

