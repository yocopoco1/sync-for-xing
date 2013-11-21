package com.gurkensalat.android.xingsync;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultString;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;
import com.gurkensalat.android.xingsync.sync.AddAccountActivity;

@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface SyncPrefs
{
	/**
	 * @see oauth.signpost.OAuth.OAUTH_TOKEN
	 */
	@DefaultString("")
	String oauth_token();

	/**
	 * @see oauth.signpost.OAuth.OAUTH_TOKEN_SECRET
	 */
	@DefaultString("")
	String oauth_token_secret();

	/**
	 * @see AddAccountActivity
	 */
	@DefaultString("")
	String sync_user();

	/**
	 * @see AddAccountActivity
	 */
	@DefaultString("lastfm_session_key")
	String session_key();
}
