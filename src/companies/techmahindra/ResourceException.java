package companies.techmahindra;

public class ResourceException extends RuntimeException{
    public ResourceException(String str){
        super(String.format("Exception occurred with %s",str));
    }
}
