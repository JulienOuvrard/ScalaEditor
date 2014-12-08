package org.alma.gl
/**
 * Classe implementant la fonction copier de l'editeur
 */
class Copier(buffer:Buffer) extends Commande{

  /**
   * Redefinition de la methone executer
   */
  def executer(){
    buffer.fillClipboard(buffer.getSelect().getContent());
  }
}