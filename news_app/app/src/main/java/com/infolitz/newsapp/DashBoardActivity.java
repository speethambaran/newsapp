package com.infolitz.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.infolitz.newsapp.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends BaseActivity {

    private ActivityDashBoardBinding binding;
    MyNotificationPublisher notificationPublisher = new MyNotificationPublisher();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {
//        loadUrl("https://newlinesmag.com/");
        loadUrl("http://vayahita.com/news1/");
/*        FirebaseMessaging.getInstance().subscribeToTopic("News")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.d("FireBaseMsssggg", msg);
                    }
                });*/


//        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent, R.color.colorBlack, R.color.colorPrimaryDark);
//        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
////                loadUrl("https://newlinesmag.com/");
//                loadUrl("http://vayahita.com/news1/");
//                binding.swipeRefresh.setRefreshing(false);
//            }
//        });
        binding.tvRefresh.setOnClickListener(v -> {
            loadUrl("http://vayahita.com/news1/");
        });

//        notificationPublisher.scheduleNotification(this, "New Notification Available", 1000);


    }

    private void loadUrl(String url) {
        binding.wvNews3.setWebViewClient(new WebViewClient());
        binding.wvNews3.getSettings().setJavaScriptEnabled(true);
        binding.wvNews3.getSettings().setDomStorageEnabled(true);
        binding.wvNews3.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        binding.wvNews3.loadUrl(url);
    }


}