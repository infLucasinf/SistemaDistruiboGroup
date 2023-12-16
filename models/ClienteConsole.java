package com.trabalhosistemas.models;

// ClienteConsole.java
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ClienteConsole implements IClienteConsole {
    private List<Membro> membros;

    public ClienteConsole() {
        this.membros = new ArrayList<>();
    }

    @Override
    public void enviarComando(String comando) throws RemoteException {
        Membro liderAtual = verificarLider();
        if (liderAtual == null) {
            System.out.println("O líder está inativo. Iniciando eleição...");
            realizarEleicao();
            return;
        }

        System.out.println("Comando recebido pelo líder " + liderAtual.getID() + ": " + comando);
        replicarComando(comando);
    }

    @Override
    public Membro verificarLider() throws RemoteException {
        Membro membroeleito = null;
        for (Membro membro : membros) {
            if (membro.eLider())
                membroeleito = membro;
        }

        return membroeleito;
    }

    public void realizarEleicao() throws RemoteException {
        System.out.println("Iniciando eleição...");
        if (verificarLider() == null) {
            iniciarEleicao();
        }
    }

    private void iniciarEleicao() {
        // Lógica para iniciar a eleição e eleger um novo líder
        // Implemente conforme necessário
    }

    private void replicarComando(String comando) throws RemoteException {
        for (Membro membro : membros) {
            if (membro.getID() != verificarLider().getID()) {
                try {
                    System.out.println("Replicando comando para o membro " + membro.getID());
                    membro.getReplica().enviarComando(comando);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}