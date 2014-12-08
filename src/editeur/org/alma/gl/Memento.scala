package org.alma.gl

/**
 * Classe permettant la sauvegarde de l'etat du Buffer apres qu'une commande ai ete executee
 * ainsi que la position du curseur
 */
class Memento(pEtat:String, pCursor:Int){
  
  private var memories:String = pEtat;
  private var cursor:Int = pCursor;
  
  /**
   * Retourne l'etat sauvegarde
   */
  def getEtat()={
      memories;
  }
  
  /**
   * Retourne la position du curseur sauvegarde
   */
  def getCursor()={
    cursor;
  }
}