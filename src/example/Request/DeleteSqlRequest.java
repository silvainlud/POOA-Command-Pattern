package example.Request;

import example.ISqlRequest;
import example.SqlServer;

/**
 * Command
 */
public class DeleteSqlRequest implements ISqlRequest {
    private SqlServer sqlServer;
    private String originalValue = null;

    public DeleteSqlRequest(SqlServer sqlServer) {

        this.sqlServer = sqlServer;
    }

    @Override
    public void execute() {
        originalValue = sqlServer.get(0);
        sqlServer.remove(0);
    }

    @Override
    public void rollback() {
        if (originalValue != null)
            sqlServer.add(0, originalValue);
    }

}
