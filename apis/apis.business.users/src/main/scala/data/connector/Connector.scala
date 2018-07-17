package data.connector

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoint}
//import com.outworkers.phantom.dsl.ContactPoints

object Connector {

  //lazy val connector: CassandraConnection = ContactPoints(Seq("127.0.0.1")).keySpace("test")
  lazy val connection: CassandraConnection = ContactPoint.local.keySpace("test")

  /*val connector = ContactPoint.local
    .noHeartbeat()
    .withClusterBuilder(
      _.withReconnectionPolicy(new ConstantReconnectionPolicy(50))
        .withSpeculativeExecutionPolicy(new ConstantSpeculativeExecutionPolicy(500, 2))
    )
    .keySpace("test")*/


}
//trait DockerConnector extends ConnectorDefault.connector.Connector
