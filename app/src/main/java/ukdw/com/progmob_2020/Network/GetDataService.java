package ukdw.com.progmob_2020.Network;

import retrofit2.http.Header;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Model.Dosen;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ukdw.com.progmob_2020.Pertemuan6.AuthorizationResponse;

public interface GetDataService {
    @GET("api/progmob/mhs/{nim_progmob}")
    Call<List<Mahasiswa>> getMahasiswa(@Path("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("api/progmob/mhs/delete")
    Call<DefaultResult>delete_mhs(
            @Field("nim") String id,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/mhs/create")
    Call<DefaultResult> add_mhs(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/mhs/update")
    Call<DefaultResult>update_mhs(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    @GET("api/progmob/dosen/{nim_progmob}")
    Call<List<Dosen>> getDosen(@Path("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("api/progmob/dosen/delete")
    Call<DefaultResult>delete_dsn(
            @Field("nidn") String nidn,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/dosen/create")
    Call<DefaultResult> add_dsn(
            @Field("nama") String nama,
            @Field("nidn") String nidn,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("gelar") String gelar,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/dosen/update")
    Call<DefaultResult>update_dsn(
            @Field("nama") String nama,
            @Field("nidn") String nidn,
            @Field("nidn_cari") String nidn_cari,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("gelar") String gelar,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    Call<AuthorizationResponse> login(@Header("Authorization")String authorization);
}