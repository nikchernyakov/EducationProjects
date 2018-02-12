public class Response<Rout extends RequestOut> {
    private Rout requestOut;

    Response(Rout requestOut){
        this.requestOut = requestOut;
    }

    Rout getRequestOut(){
        return requestOut;
    }
}
