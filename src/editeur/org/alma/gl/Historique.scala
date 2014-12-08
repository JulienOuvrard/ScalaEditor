package org.alma.gl

/**
 * Classe permettant de sauvegarder les "Memento" du Buffer 
 */
class Historique(){

  private var liste:List[Memento] = Nil;
  
  /**
   * Ajouter un "Memento" a la liste a l'index voulu
   * @param pMemento Le "Memento" a ajouter
   * @param id L'index a laquelle inserer le "Memento"
   */
  def ajouterMemento(pMemento:Memento, id:Int){
    if(id < (liste.length-1)){
      var i:Int = 0;
      for(i <- 1 to (getTailleMemento()-id-1)){
        liste = liste.init;
      }
      liste = liste:+pMemento;
    }else{
      liste = liste:+pMemento;
    }
  }
  
  /**
   * Retourne le "Memento" correspondant a l'index
   * @param pIndex Index du "Memento" voulu
   * @return Memento
   */
  def getMemento(pIndex:Int)={
    liste(pIndex);
  }
  
  /**
   * Retourne la taille de la liste des "Memento"
   */
  def getTailleMemento()={
    liste.length-1;
  }
}