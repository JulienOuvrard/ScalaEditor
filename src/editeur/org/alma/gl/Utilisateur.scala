package org.alma.gl

/**
 * Classe concrete d'observateur
 */
class Utilisateur(name:String) extends Observateur{
  
  private var nom:String = name;
  
  /**
   * Redefintion de la methode actualiser : affiche le nom de l'utilisateur puis le contenu du buffer observe
   * @param o L'observable observe
   * @param content Le contenu de l'observable
   */
  def actualiser(o:Observable, content:String){
    if(o.isInstanceOf[Buffer]){
      System.out.println(nom+" :"+content);
    }
  }
  
  /**
   * Abonne l'utilisateur au Buffer et actualise le contenu
   * @param buffer Le Buffer auquel s'abonner
   */
  def abonnement(buffer:Buffer){
    buffer.ajouterObservateur(this);
    actualiser(buffer, buffer.getContent());
  }
  
  /**
   * Desabonne l'utilisateur au Buffer
   * @param buffer Le Buffer auquel se desabonner
   */
  def desabonnement(buffer:Buffer){
    buffer.supprObservateur(this);
  }
  
  /**
   * Affiche le nom de l'utilisateur
   */
  def printNom(){
    print(nom);
  }
}