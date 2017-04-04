package app.isfaaghyth.identitasku.model;

import android.support.v7.view.ActionBarPolicy;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.Request;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class DataModel {
    @SerializedName("data") private Data data;

    public static class Data {
        @SerializedName("id") private int id;
        @SerializedName("name") private String name;
        @SerializedName("position") private String position;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }
    }

    public Data getData() {
        return data;
    }

//    public List<Data> getDatas() {
//        return datas;
//    }

    public static class Builder {
        public Request build(String URL) {
            return new Request.Builder()
                    .get()
                    .url(URL)
                    .build();
        }
    }
}
