package bonc.demopractice_allkinsoff.rx_java;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by chen1 on 2017/8/31.
 */

public interface HttpApi {
    @GET
    Observable<LoginResponse>login(@Body LoginRequest request);

    @GET
    Observable<RegisterResponse> resgister(@Body RegisterRequest registerRequest);
}
