package ukdw.com.progmob_2020.Network;

import java.security.SecureRandom;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import com.squareup.okhttp.OkHttpClient;
import okhttp3.OkHttpClient;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import okhttp3.Interceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://argouchiha.000webhostapp.com/";

    public static Retrofit getRetrofitTwitterInstance() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static class ServiceClient {

        private static Retrofit.Builder builder = new Retrofit.Builder();
        private static OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        public static GetDataService buildServiceClient() {
            return builder.baseUrl("https://sandbox.openrainbow.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                    .create(GetDataService.class);
        }
    }
}
