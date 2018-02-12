public class Request1<Rout extends RequestOut> implements Request {

    private Rout out;

    Request1(Rout requestOut){
        this.out = requestOut;
    }

    public Rout getOut(){
        return out;
    }

    static class Out implements RequestOut {
        int result;

        Out(int result){
            this.result = result;
        }

        int getResult(){
            return result;
        }
    }
}
