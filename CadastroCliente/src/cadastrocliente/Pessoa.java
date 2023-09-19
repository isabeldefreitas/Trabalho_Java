/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrocliente;

/**
 *
 * @author tatip
 */
  public class Pessoa {
private String nome;
private String telefone;
private String Email;
private String Logradouro;
private String Numero;
private String Complemento;
private String Bairro;
private String Cidade;
private String Estado;
private String Cep;

public String obterNome(){
return nome;
}
public String obterTelefone(){
return telefone;
}

public void atualizarNome(String nome){
this.nome = nome;
}

public void atualizarTelefone(String telefone){
this.telefone = telefone;
}
public String obterEmail(){
return Email;
}
public void atualizarEmail(String nome){
this.Email = Email;
}
public String obterLogradouro(){
return Logradouro;
}
public void atualizarLogradouro(String nome){
this.Logradouro = Logradouro;
}
public String obterNumero(){
return Numero;
}
public void atualizarNumero(String nome){
this.Numero = Numero;
}
public String obterComplemento(){
return Complemento ;
}
public void atualizarComplemento(String nome){
this.Complemento = Complemento;
}
public String obterBairro(){
return Bairro ;
}
public void atualizarBairro(String nome){
this.Bairro = Bairro ;
}
public String obterCidade(){
return Cidade;
}
public void atualizarCidade(String nome){
this.Cidade = Cidade;
}
public String obterEstado(){
return Estado ;
}
public void atualizarEstado(String nome){
this.Estado = Estado;
}
public String obterCep(){
return Cep;
}
public void atualizarCep(String nome){
this.Cep =Cep ;
}
  }