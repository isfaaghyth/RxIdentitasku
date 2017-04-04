package app.isfaaghyth.identitasku.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class OkHttpTimeOut {
    protected static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .build();
}
