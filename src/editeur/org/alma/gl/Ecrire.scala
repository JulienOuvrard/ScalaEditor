package org.alma.gl

/**
 * Classe implementant la fonction ecrire de l'editeur
 */
class Ecrire(buffer:Buffer, text:String) extends Commande{
  
  /**
   * Redefinition de la methode executer
   */
  def executer(){
    var sub1:String = buffer.getContent().substring(0, buffer.getSelect().getDebut());
    var sub2:String = buffer.getContent().substring(buffer.getSelect().getFin(), buffer.getContent().length());
    buffer.setContent(sub1 + text + sub2);
    
    buffer.getSelect().setDebut(sub1.length() + text.length());
    buffer.getSelect().setFin(sub1.length() + text.length());
    buffer.getSelect().resetContent();
    
    buffer.memoire();
    buffer.actualiser();
  }
}