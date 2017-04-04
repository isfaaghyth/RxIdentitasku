package app.isfaaghyth.identitasku.network;

import app.isfaaghyth.identitasku.model.DetailDataModel;
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
        Request request = new Builder().build(URLs.getUrlMain());
        return OkHttp.streamStrings(client, request);
    }

    public static Observable<String> getDatasById(int id) {
        Request request = new Builder().build(URLs.getUrlDetail(id));
        return OkHttp.streamStrings(client, request);
    }

    public static class Builder {
        public Request build(String URL) {
            return new Request.Builder().get().url(URL).build();
        }
    }

}
