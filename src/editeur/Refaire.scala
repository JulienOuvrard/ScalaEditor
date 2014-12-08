

class Refaire(buffer:Buffer) extends Commande{
  
  def execute(){
    if(buffer.getIndex() < buffer.getHistoric().getTailleMemento()){
      buffer.recuperateur(buffer.getHistoric().getMemento(buffer.getIndex()+2));
      buffer.setIndex(buffer.getIndex()+2);
      buffer.actualiser();
    }
  }

}