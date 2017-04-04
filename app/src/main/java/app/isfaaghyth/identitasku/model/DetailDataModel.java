package app.isfaaghyth.identitasku.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class DetailDataModel {
    @SerializedName("status") private String status;
    @SerializedName("data") private List<Data> datas;

    public List<Data> getDatas() {
        return datas;
    }

    public String getStatus() {
        return status;
    }

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
}
