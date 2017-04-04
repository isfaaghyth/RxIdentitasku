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

public class DetailDataModel {
    @SerializedName("status") private String status;
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

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }
}
