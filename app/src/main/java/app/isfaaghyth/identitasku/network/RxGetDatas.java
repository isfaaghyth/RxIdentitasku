package app.isfaaghyth.identitasku.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import app.isfaaghyth.identitasku.model.DataModel;
import app.isfaaghyth.identitasku.utils.URLs;
import okhttp3.Request;
import rx.Observable;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class RxGetDatas extends OkHttpTimeOut {

    public static Observable<String> getDatas() {
        Request request = new DataModel.Builder().build(URLs.getUrlMain());
        return OkHttp.streamStrings(client, request);
    }

    public static Observable<String> getDatasById(int id) {
        Request request = new DataModel.Builder().build(URLs.getUrlDetail(id));
        return OkHttp.streamStrings(client, request);
    }

}
