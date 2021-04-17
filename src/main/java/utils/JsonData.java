package utils;

import com.google.gson.Gson;

import static java.lang.String.format;

public class JsonData {

    /**
     * The method getJsonData.
     *
     * @param <T>          the Generic parameter.
     * @param jsonFileName this is JSON file from resources.
     * @param tClass       this is Model Class from model package.
     * @param folderName   this is folder name there put JSON file.
     * @return json data.
     */
    public static <T> T getJsonData(final String jsonFileName, final Class<T> tClass, final String folderName) {
        final String pathToFolder = PropertiesReader.getResourceAsString(format(folderName + "/%s.json", jsonFileName));
        return new Gson().fromJson(pathToFolder, tClass);
    }
}
