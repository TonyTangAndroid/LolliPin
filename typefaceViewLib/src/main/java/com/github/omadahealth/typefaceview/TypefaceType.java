package com.github.omadahealth.typefaceview;

import android.util.Log;

/**
 * Created by stoyan on 4/8/15.
 */
public enum TypefaceType {
    ROBOTO_REGULAR(0, "Roboto-Regular.ttf", "roboto_regular"),
    ROBOTO_LIGHT(1, "Roboto-Light.ttf", "roboto_light");

    /**
     * The int value of this enum, defined in attr.xml
     */
    private int mValue;

    /**
     * The resource name in assets of the typeface file
     */
    private String mAssetName;

    /**
     * The attribute name of the typeface from xml
     */
    private String mAttrName;

    /**
     * Constructor to set the enum int value and corresponding asset
     * file name
     *
     * @param value     The value
     * @param assetName The file name
     */
    TypefaceType(int value, String assetName, String attrName) {
        this.mValue = value;
        this.mAssetName = assetName;
        this.mAttrName = attrName;
    }

    /**
     * Get the {@link TypefaceType} for the given enum value that matches the
     * {@link #mValue} of the {@link TypefaceType}
     *
     * @param val The enum value
     * @return
     */
    public static TypefaceType getTypeface(int val) {
        switch (val) {
            case 1:
                return ROBOTO_LIGHT;
            case 0:
                return ROBOTO_REGULAR;
            default:
                Log.w("TypefaceType", "Typeface  not supported, defaulting to roboto_regular");
                return ROBOTO_REGULAR;
        }
    }

    public static TypefaceType getTypeface(String name) {
        switch (name) {
            case "roboto_light":
                return ROBOTO_LIGHT;
            case "roboto_regular":
                return ROBOTO_REGULAR;
            default:
                Log.w("TypefaceType", "Typeface " + name + " not supported, defaulting to roboto_regular");
                return ROBOTO_REGULAR;

        }
    }

    /**
     * Gets the enum value of this typeface as defined in attr.xml
     *
     * @return
     */
    public int getValue() {
        return mValue;
    }

    /**
     * Gets the resource name in assets of the typeface file
     *
     * @return
     */
    public String getAssetFileName() {
        return mAssetName;
    }
}
