package com.talmeida.weather.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.talmeida.weather.R;
import com.talmeida.weather.databinding.ActivityMainBinding;
import com.talmeida.weather.presenters.WeatherPresenter;
import com.talmeida.weather.services.entity.ForecastResponse;
import com.talmeida.weather.services.entity.User;

public class MainActivity extends AppCompatActivity implements MainView {

    private WeatherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final User user = new User("Test", "User", 24);
        binding.setUser(user);
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.incrementAge();
            }
        });
        Picasso.with(this)
                .load("http://icons.wxug.com/i/c/k/clear.gif")
                .into(binding.imageView);
        presenter = new WeatherPresenter(this);
        presenter.loadForecast();
    }

    @Override
    public void onForecastLoaded(ForecastResponse response) {
        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
    }
}
