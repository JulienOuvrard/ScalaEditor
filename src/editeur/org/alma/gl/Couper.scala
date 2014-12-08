package org.alma.gl
/**
 * Classe implementant la fonction couper de l'editeur
 */
class Couper(buffer:Buffer) extends Commande{

  /**
   * Redefinition de la methode executer
   */
  def executer(){
    buffer.fillClipboard(buffer.getSelect().getContent());
    var sub1:String=buffer.getContent().substring(0, buffer.getSelect().getDebut());
    var sub2:String=buffer.getContent().substring(buffer.getSelect().getDebut(), buffer.getSelect().getFin());
    var sub3:String=buffer.getContent().substring(buffer.getSelect().getFin(), buffer.getLength());
    buffer.setContent(sub1 + sub3);
    buffer.getSelect().setDebut(buffer.getSelect().getDebut());
    buffer.getSelect().setFin(buffer.getSelect().getDebut());
    buffer.getSelect().resetContent();
    
    buffer.memoire();
    buffer.actualiser();
  }
}