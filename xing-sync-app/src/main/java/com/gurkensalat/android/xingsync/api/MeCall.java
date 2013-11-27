package com.gurkensalat.android.xingsync.api;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.googlecode.androidannotations.annotations.EBean;

@EBean
public class MeCall // implements XingApiCall
{
	private static final String TAG = "xingsync.MeCall";

	public JSONArray perform(final String... args)
	{
		// Hardcoded Mock for now

		StringBuffer sb = new StringBuffer(1024);

		sb.append("{");
		sb.append("  \"users\": [");
		sb.append("    {");
		sb.append("      \"id\": \"3382304_64b174\",");
		sb.append("      \"first_name\": \"Hakan\",");
		sb.append("      \"last_name\": \"Tandogan\",");
		sb.append("      \"display_name\": \"Hakan Tandogan\"");
		sb.append("    }");
		sb.append("  ]");
		sb.append("}");

		Log.i(TAG, sb.toString());

		JSONArray jsonArray = new JSONArray();
		try
		{
			jsonArray = new JSONArray(sb.toString());
			Log.i(TAG, jsonArray.toString());
		}
		catch (JSONException e)
		{
			Log.e(TAG, "while parsing answer string", e);
		}

		return jsonArray;
	}
}
