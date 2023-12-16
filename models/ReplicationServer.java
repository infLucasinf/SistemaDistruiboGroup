package com.trabalhosistemas.models;

//ReplicationServer.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ReplicationServer extends UnicastRemoteObject implements ReplicationInterface {
 private List<Membro> membros;
 private ClienteConsole clienteConsole;

 public ReplicationServer() throws RemoteException {
     this.membros = new ArrayList<>();
     this.clienteConsole = new ClienteConsole();
 }

 @Override
 public void enviarComando(String comando) throws RemoteException {
     Membro liderAtual = clienteConsole.verificarLider();
     if (liderAtual == null) {
         System.out.println("O líder está inativo. Iniciando eleição...");
         clienteConsole.realizarEleicao();
         return;
     }

     System.out.println("Comando recebido pelo líder " + liderAtual.getID() + ": " + comando);
     replicarComando(comando);
 }

 @Override
 public boolean verificarLider(int id) throws RemoteException {
     Membro liderAtual = clienteConsole.verificarLider();
     return liderAtual != null && liderAtual.getID() == id;
 }

 private void replicarComando(String comando) throws RemoteException {
     for (Membro membro : membros) {
         if (membro.getID() != clienteConsole.verificarLider().getID()) {
             try {
                 System.out.println("Replicando comando para o membro " + membro.getID());
                 membro.getReplica().enviarComando(comando);
             } catch (RemoteException e) {
                 e.printStackTrace();
             }
         }
     }
 }

@Override
public void sendDataToReplicas(String data, int i) {
	// TODO Auto-generated method stub
	
}
}