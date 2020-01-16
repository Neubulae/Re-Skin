package com.sekwah.reskin.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;

public class DataStorage {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private File dataFolder;

    public DataStorage(File dataStorageLoc) {
        this.dataFolder = dataStorageLoc;
    }

    public <T> T loadJson(Type dataHolder, String location) {
        InputStream jsonResource = this.loadResource(location);
        if(jsonResource == null) {
            return null;
        }
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(jsonResource));
        return gson.fromJson(bufReader, dataHolder);
    }

    /**
     * @param dataHolder data class
     * @param location filename
     * @param saveAfterLoad should save after loading? Updates config files that have missing fields.
     * @param <T>
     * @return
     */
    public <T> T loadJson(Class<T> dataHolder, String location, boolean saveAfterLoad) {
        T data = this.loadJson(dataHolder, location);
        if(saveAfterLoad) this.storeJson(data, location);
        return data;
    }

    public <T> T loadJson(Class<T> dataHolder, String location) {
        InputStream jsonResource = this.loadResource(location);
        if(jsonResource == null) {
            try {
                return dataHolder.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(jsonResource));
        return gson.fromJson(bufReader, dataHolder);
    }

    public void storeJson(Object dataHolder, String location) {
        String json = gson.toJson(dataHolder);
        try {
            FileWriter fileWriter = new FileWriter(new File(this.dataFolder, location));
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the file exists before trying to load it.
     * <p>
     * @param location
     * @return
     */
    public InputStream loadResource(String location) {
        File inFile = new File(dataFolder, location);
        if (inFile.exists() && !inFile.isDirectory()) {
            try {
                return new FileInputStream(inFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }


}
