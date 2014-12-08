

class Copier(buffer:Buffer) extends Commande{

  def execute(){
    buffer.setCb(buffer.getSelect().getContent());
    buffer.getSelect().resetContent();
  }
  
}