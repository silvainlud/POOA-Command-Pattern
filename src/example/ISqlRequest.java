package example;

/**
 * ICommand
 */
public interface ISqlRequest {

    public void execute();

    public void rollback();

}
