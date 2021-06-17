package RestApi;

public class BaseManager {
    public RestApi getrestapi(){

        RestApiClient restApiClient=new RestApiClient(Baseurl.baseurl);
        return restApiClient.getRestApi();


    }
}
