package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try {
            // Parse the string to a JSON Object called sandwichJson

            JSONObject sandwichJson = new JSONObject(json);
            // get the name Object from the sandwichJson object, and get its values
            JSONObject nameObject = sandwichJson.getJSONObject(NAME);
            String sandwichName = nameObject.getString(MAIN_NAME);
            JSONArray alsoKnownAsArray = nameObject.getJSONArray(ALSO_KNOWN_AS);
            String sandwichPlaceOfOrigin = sandwichJson.getString(PLACE_OF_ORIGIN);
            String sandwichDescription = sandwichJson.getString(DESCRIPTION);
            String sandwichImage = sandwichJson.getString(IMAGE);
            JSONArray sandwichIngredients = sandwichJson.getJSONArray(INGREDIENTS);

            //Parsing the Json array into a String ArrayList for the sandwich ingredients and aka lists

            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < sandwichIngredients.length(); i++) {
                ingredientsList.add(sandwichIngredients.getString(i));
            }

            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(i));
            }

            //Create a new sandwich objects with the parameters

            return new Sandwich(sandwichName, alsoKnownAsList, sandwichPlaceOfOrigin, sandwichDescription, sandwichImage, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
