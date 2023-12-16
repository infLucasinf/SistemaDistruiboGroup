package com.trabalhosistemas.models;

// Membro.java
public class Membro {
    private int id;
    private int posicao;

    public Membro(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean eLider() {
        // Lógica para verificar se este membro é o líder
        // Pode ser implementada com base em regras específicas do seu sistema
        return false;
    }

	public ClienteConsole getReplica() {
		// TODO Auto-generated method stub
		return null;
	}
}