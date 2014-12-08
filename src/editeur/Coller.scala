

class Coller(buffer:Buffer) extends Commande{
  
  def execute(){
    var deb=buffer.getSelect().getDebut();
    var fin=buffer.getSelect().getFin();
    
    var sub1:String=buffer.getContent().substring(0, deb);
    var sub2:String=buffer.getContent().substring(fin, buffer.getLength());
    buffer.setContent(sub1+buffer.getCb().getContent()+sub2);
    
    buffer.getSelect().setDebut(sub1.length()+buffer.getCb().getLength());
    buffer.getSelect().setFin(sub1.length()+buffer.getCb().getLength());
    
    buffer.memoire();
    buffer.actualiser();
  }
  
}