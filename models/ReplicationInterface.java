package com.trabalhosistemas.models;

// ReplicationInterface.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReplicationInterface extends Remote {
    void enviarComando(String comando) throws RemoteException;
    boolean verificarLider(int id) throws RemoteException;
	void sendDataToReplicas(String data, int i);
}