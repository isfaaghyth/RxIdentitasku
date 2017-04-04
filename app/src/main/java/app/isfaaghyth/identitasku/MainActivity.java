package app.isfaaghyth.identitasku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.isfaaghyth.identitasku.model.DataModel;
import app.isfaaghyth.identitasku.model.DetailDataModel;
import app.isfaaghyth.identitasku.network.RxGetDatas;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_name) TextView txtName;
    @BindView(R.id.txt_company) TextView txtCompany;

    private Subscription subscriber = new CompositeSubscription();
    private Gson gson = new GsonBuilder().create();
    private static int USER_ID = 2;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Observable<List<String>> test = Observable.zip(
                RxGetDatas.getDatas(),
                RxGetDatas.getDatasById(USER_ID), (s, s2) -> {
                    List<String> test1 = new ArrayList<>();
                    test1.add(s);
                    test1.add(s2);
                    return test1;
                }
        );

        subscriber = test.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(List<String> strings) {
        String data1, data2;
        data1 = strings.get(0);
        data2 = strings.get(1);

        DetailDataModel data = gson.fromJson(data1, DetailDataModel.class);
        txtName.setText(data.getDatas().get(USER_ID - 1).getName());

        DataModel dataa = gson.fromJson(data2, DataModel.class);
        txtCompany.setText(dataa.getData().getPosition());
    }

    private void onError(Throwable err) {
        Log.d("ERR", err.getMessage());
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }
}
