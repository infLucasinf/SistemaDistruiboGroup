package com.trabalhosistemas.models;

// IClienteConsole.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClienteConsole extends Remote {
    void enviarComando(String comando) throws RemoteException;
    Membro verificarLider() throws RemoteException;
}