

class Utilisateur(name:String) extends Observateur{
  
  var nom:String = name;
  
  def actualiser(o:Observable, content:String){
    if(o.isInstanceOf[Buffer]){
      System.out.println(nom+" :"+content);
    }
  }
  
  def abonnement(buffer:Buffer){
    buffer.ajouterObservateur(this);
    actualiser(buffer, buffer.getContent());
  }
  
  def desabonnement(buffer:Buffer){
    buffer.supprObservateur(this);
  }
  
  def getNom(){
    println(nom);
  }
  
}