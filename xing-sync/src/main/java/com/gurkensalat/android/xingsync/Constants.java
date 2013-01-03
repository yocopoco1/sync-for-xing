package com.gurkensalat.android.xingsync;

import com.gurkensalat.android.xingsync.keys.XingOAuthKeys;

import android.provider.ContactsContract.Data;

public class Constants
{
    /**
     * Number of characters to cut from logger TAG name length.
     */
    public static final int PACKAGE_PREFIX_LENGTH = "com.gurkensalat.android.".length();

    /**
     * Account type string.
     */
    public static final String ACCOUNT_TYPE = "com.gurkensalat.android.xingsync";

    /**
     * Provider authority
     */
    public static final String PROVIDER_AUTHORITY = "com.android.contacts";

    /**
     * Authtoken type string.
     */
    public static final String AUTHTOKEN_TYPE = "com.gurkensalat.android.xingsync";

    /**
     * What should the default group name be?
     */
    public static final String DEFAULT_GROUP_NAME = "XING";

    /**
     * Root name for all our preferences
     */
    public final static String PREFS_NAME = "xingsync_prefs";

    /**
     * Do we mock anything at all? Should be a preference item.
     */
    public static final Boolean MOCK_MODE = true;

    /**
     * Do we mock network access? Should be a preference item.
     */
    public static final Boolean MOCK_NETWORK_ACCESS = true;

    /**
     * 
     */
    public static final String ME_REQUEST = XingOAuthKeys.API_URL_BASE + "/users/me";

    /**
     * MIME-type used when storing a profile {@link Data} entry.
     */
    public static final String MIME_PROFILE = "vnd.android.cursor.item/vnd.com.gurkensalat.android.xingsync.profile";

    public static final String DATA_PID = Data.DATA1;

    public static final String DATA_SUMMARY = Data.DATA2;

    public static final String DATA_DETAIL = Data.DATA3;
}