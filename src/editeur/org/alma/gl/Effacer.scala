package org.alma.gl

/**
 * Classe implementant la fonction effacer de l'editeur
 */
class Effacer(buffer:Buffer) extends Commande{
  
  /**
   * Redefinition de la methode executer
   */
  def executer(){
    if(buffer.getLength() > 0){
      var sub1:String = "";
      if(buffer.getSelect().getDebut() == buffer.getSelect().getFin()){
        sub1 = buffer.getContent().substring(0, buffer.getSelect().getFin()-1);
      }else{
        sub1 = buffer.getContent().substring(0, buffer.getSelect().getDebut());
      }
      var sub2:String = buffer.getContent().substring(buffer.getSelect().getFin(), buffer.getLength());
      buffer.setContent(sub1 + sub2);
      buffer.getSelect().setDebut(sub1.length());
      buffer.getSelect().setFin(sub1.length());
      buffer.getSelect().resetContent();
      
      buffer.memoire();
      buffer.actualiser();
    }
  }
}