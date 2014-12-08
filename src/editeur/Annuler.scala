

class Annuler(buffer:Buffer) extends Commande{
  
  def execute(){
    if(buffer.getIndex() == buffer.getHistoric().getTailleMemento()){
			buffer.setIndex(buffer.getHistoric().getTailleMemento()-1);
		}
		if(buffer.getIndex() >= 0){
			buffer.recuperateur(buffer.getHistoric().getMemento(buffer.getIndex()));
			buffer.setIndex(buffer.getIndex() - 1);
			buffer.actualiser();
		}
  }

}