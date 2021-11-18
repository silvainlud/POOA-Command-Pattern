package example;

import java.util.LinkedList;

/**
 * Invoker
 */
public class SqlTransaction {

    LinkedList<ISqlRequest> pendingSqlRequest = new LinkedList<>();

    LinkedList<ISqlRequest> executedSqlRequest = new LinkedList<>();

    public SqlTransaction() {

    }

    public void addSqlRequest(ISqlRequest sqlRequest) {
        pendingSqlRequest.add(sqlRequest);
    }

    public void launchRequest() {
        while (!pendingSqlRequest.isEmpty()) {
            ISqlRequest sql = pendingSqlRequest.getFirst();
            sql.execute();
            executedSqlRequest.addLast(sql);
            pendingSqlRequest.removeFirst();
        }

    }

    public void cancelRequest() {
        while (!executedSqlRequest.isEmpty()) {
            ISqlRequest sql = executedSqlRequest.getLast();
            sql.rollback();
            executedSqlRequest.removeLast();
        }
    }


}
