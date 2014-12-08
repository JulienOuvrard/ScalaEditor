package org.alma.gl

/**
 * Classe implementant la fonction coller de l'editeur
 */
class Coller(buffer:Buffer) extends Commande{
  
   /**
   * Redefinition de la methode executer
   */
  def executer(){
    var deb:Int = buffer.getSelect().getDebut();
    var fin:Int = buffer.getSelect().getFin();
    
    var sub1:String = buffer.getContent().substring(0, deb);
    var sub2:String = buffer.getContent().substring(fin, buffer.getLength());
    buffer.setContent(sub1 + buffer.getClipboard().getContent() + sub2);
    
    buffer.getSelect().setDebut(sub1.length() + buffer.getClipboard().getLength());
    buffer.getSelect().setFin(sub1.length() + buffer.getClipboard().getLength());
    
    buffer.memoire();
    buffer.actualiser();
  }
}