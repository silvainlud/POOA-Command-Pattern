package example;

import example.Request.DeleteSqlRequest;
import example.Request.UpdateSqlRequest;

public class SqlClient {

    public static void main(String[] args) {
        // Création du serveur
        SqlServer sqlServer = new SqlServer();

        //Création d'une transaction
        SqlTransaction sqlTransaction = new SqlTransaction();

        // Instanciation de 2 commands : Update et Delete
        UpdateSqlRequest updateSqlRequest = new UpdateSqlRequest(sqlServer);
        DeleteSqlRequest deleteSqlRequest = new DeleteSqlRequest(sqlServer);

        //Ajout des 2 commandes au sqlTransaction
        sqlTransaction.addSqlRequest(updateSqlRequest);
        sqlTransaction.addSqlRequest(deleteSqlRequest);

        System.out.println(" --- Avant Exécution --- ");
        System.out.println(sqlServer);

        // Lancement des commandes à l'aide du client
        sqlTransaction.launchRequest();
        System.out.println("\n --- Après Exécution --- ");
        System.out.println(sqlServer);

        // Annulation des commandes à l'aide du client
        sqlTransaction.cancelRequest();
        System.out.println("\n --- RollBack --- ");
        System.out.println(sqlServer);


    }
}
