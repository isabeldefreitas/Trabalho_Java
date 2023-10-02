/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrocliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tatip
 */
  public class Pessoa {
      
        private String nome;
        private String telefone;
        private String email;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String estado;
        private String cep;

        public String obterNome(){
        return nome;
        }
        public String obterTelefone(){
        return telefone;
        }
        public String obterEmail(){
        return email;
        }
        public String obterLogradouro(){
        return logradouro;
        }

        public String obterNumero(){
        return numero;
        }


        public String obterComplemento(){
        return complemento ;
        }

        public String obterBairro(){
        return bairro ;
        }

        public String obterCidade(){
        return cidade;
        }

        public String obterEstado(){
        return estado ;
        }
        public String obterCep(){
        return cep;
        }
        public void atualizarNome(String nome){
        this.nome = nome;
        }

        public void atualizarTelefone(String telefone){
        this.telefone = telefone;
        }

        public void atualizarEmail(String email){
        this.email = email;
        }

        public void atualizarLogradouro(String logradouro){
        this.logradouro = logradouro;
        }

        public void atualizarNumero(String numero){
        this.numero = numero;
        }

        public void atualizarComplemento(String complemento){
        this.complemento = complemento;
        }

        public void atualizarBairro(String bairro){
        this.bairro = bairro ;
        }

        public void atualizarCidade(String cidade){
        this.cidade = cidade;
        }

        public void atualizarEstado(String estado){
        this.estado = estado;
        }

        public void atualizarCep(String cep){
        this.cep =cep ;
        }
        
        public String salvar() {
            try {
                FileWriter fw = new FileWriter("Pessoa.txt", true); 
                PrintWriter pw = new PrintWriter(fw);
                pw.println("Nome:" + this.nome);
                pw.println("Telefone:" + this.telefone);
                pw.println("Email:" + this.email);
                pw.println("Logradouro:" + this.logradouro);
                pw.println("Numero:" + this.numero);
                pw.println("Complemento:" + this.complemento);
                pw.println("Bairro:" + this.bairro);
                pw.println("Cidade:" + this.cidade);
                pw.println("Estado:" + this.estado);
                pw.println("Cep:" + this.cep);
                pw.println(); 
                pw.flush();
                pw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

  }