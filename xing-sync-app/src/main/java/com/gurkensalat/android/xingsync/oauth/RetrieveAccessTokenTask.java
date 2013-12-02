package com.gurkensalat.android.xingsync.oauth;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;

import com.gurkensalat.android.xingsync.R;
import com.gurkensalat.android.xingsync.sync.AddAccountActivity_;

public class RetrieveAccessTokenTask extends AsyncTask<Uri, Void, Void>
{
	private static Logger LOG = LoggerFactory.getLogger(RetrieveAccessTokenTask.class);

	private Context context;
	private OAuthConsumer consumer;
	private OAuthProvider provider;

	// TODO convert to annotated preferences later
	private SharedPreferences prefs;

	public RetrieveAccessTokenTask(Context context, OAuthConsumer consumer, OAuthProvider provider, SharedPreferences prefs)
	{
		this.context = context;
		this.consumer = consumer;
		this.provider = provider;
		this.prefs = prefs;
	}

	/**
	 * Retrieve the oauth_verifier, and store the oauth and oauth_token_secret
	 * for future API calls.
	 */
	@Override
	protected Void doInBackground(Uri... params)
	{
		final Uri uri = params[0];

		final String oauth_verifier = uri.getQueryParameter(OAuth.OAUTH_VERIFIER);

		LOG.info("doInBackground");

		try
		{
			provider.retrieveAccessToken(consumer, oauth_verifier);

			final Editor edit = prefs.edit();
			edit.putString(OAuth.OAUTH_TOKEN, consumer.getToken());
			edit.putString(OAuth.OAUTH_TOKEN_SECRET, consumer.getTokenSecret());
			edit.commit();

			String token = prefs.getString(OAuth.OAUTH_TOKEN, "");
			String secret = prefs.getString(OAuth.OAUTH_TOKEN_SECRET, "");

			consumer.setTokenWithSecret(token, secret);
			Intent intent = new Intent(context, AddAccountActivity_.class);
			intent.setAction(context.getString(R.string.LOGIN_INTENT_ACTION));
			context.startActivity(intent);

			LOG.info("OAuth - Access Token Retrieved");
		}
		catch (Exception e)
		{
			LOG.error("OAuth - Access Token Retrieval Error", e);
		}

		return null;
	}
}