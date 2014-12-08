package org.alma.gl
/**
 * Classe implementant la fonction refaire de l'editeur
 */
class Refaire(buffer:Buffer) extends Commande{
  
  /**
   * Redefinition de la methode executer
   */
  def executer(){
    if(buffer.getIndex() < buffer.getHistoric().getTailleMemento()){
      buffer.recuperateur(buffer.getHistoric().getMemento(buffer.getIndex()+2));
      buffer.setIndex(buffer.getIndex()+2);
      buffer.actualiser();
    }
  }
}