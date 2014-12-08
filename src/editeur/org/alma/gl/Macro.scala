package org.alma.gl

/**
 * Classe permettant a l'utilisateur de definir une macro
 */
class Macro extends Commande{
  
  private var commandList:List[Commande] = Nil;
  
  /**
   * Ajoute une commande a la liste des commandes de la macro
   * @param c La commande a ajouter
   */
  def ajouterCommande(c:Commande){
    commandList = commandList:+c;
  }

  /**
   * Redefinition de la methode executer
   */
  def executer(){
    commandList.foreach{
      c => c.executer();
    }
  }
  
  /**
   * Retourne la liste des commandes de la macro
   */
  def getMacros()={
    commandList;
  }
}