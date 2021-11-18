package example.Request;

import example.ISqlRequest;
import example.SqlServer;

/**
 * Command
 */
public class UpdateSqlRequest implements ISqlRequest {

    private SqlServer sqlServer;
    private String originalValue = null;

    public UpdateSqlRequest(SqlServer sqlServer) {

        this.sqlServer = sqlServer;
    }

    @Override
    public void execute() {
        originalValue = sqlServer.get(1);
        sqlServer.set(1, "value5555");
    }

    @Override
    public void rollback() {
        if (originalValue != null)
            sqlServer.set(1, originalValue);
    }
}
