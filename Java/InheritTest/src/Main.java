public class Main {

    public static void main(String args[]) {
        Request1<Request1.Out> request = new Request1<>(new Request1.Out(1));
        Response<Request1.Out> response = getResponse(request);


        //System.out.println(response.getRequestOut() instanceof Request1.Out);
        Request1.Out out = /*(Request1.Out)*/ response.getRequestOut();

        System.out.println(out.getResult());
    }

    public static <Rout extends RequestOut> Response<Rout> getResponse(Request<Rout> request){
        Response<Rout> response = new Response<>(request.getOut());
        return response;
    }

}
