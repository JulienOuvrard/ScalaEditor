

trait Observable {

  var obs:List[Observateur] = Nil;
  
  def ajouterObservateur(o:Observateur){
    obs = obs:+o;
  }
  
  def supprObservateur(o:Observateur){
    obs = obs diff List(o);
  }
  
  def notifierObservateur(content:String){
    obs.foreach{
      o => o.actualiser(this, content);
    }
  }
}