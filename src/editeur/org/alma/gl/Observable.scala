package org.alma.gl

/**
 * Interface des observables
 */
trait Observable {
  
  private var obs:List[Observateur] = Nil;
  
  /**
   * Ajoute une observateur a la liste des observateurs
   * @param o L'observateur a ajouter
   */
  def ajouterObservateur(o:Observateur){
    obs = obs:+o;
  }
  
  /**
   * Supprime un observateur de la liste des observeurs
   * @param o L'observateur a supprimer
   */
  def supprObservateur(o:Observateur){
    obs = obs diff List(o);
  }
  
  /**
   * Notifie les observateurs des changements apparus sur le contenu du Buffer
   * @param content Le contenu du Buffer modifie
   */
  def notifierObservateur(content:String){
    obs.foreach{
      o => o.actualiser(this, content);
    }
  }
  
  /**
   * Retourne la liste des observateurs
   */
  def getObservateurs()={
    obs;
  }
}