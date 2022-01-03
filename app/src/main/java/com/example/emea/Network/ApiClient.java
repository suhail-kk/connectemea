package com.example.emea.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        OkHttpClient client = getClient();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://student-profile-api.herokuapp.com/")


//                    .baseUrl("http://192.168.1.6:9000/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                //.addNetworkInterceptor(new AddHeaderInterceptor())
                //.addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .build();
        client.connectionPool().evictAll();
        return client;
    }


}
