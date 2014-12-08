

class Effacer(buffer:Buffer) extends Commande{
  
  def execute(){
    if((buffer.getLength() > 0) && (buffer.getSelect().getDebut() == buffer.getSelect().getFin())){
      var sub1:String = buffer.getContent().substring(0, buffer.getSelect().getFin()-1);
      buffer.setContent(sub1);
      buffer.getSelect().setDebut(buffer.getLength());
      buffer.getSelect().setFin(buffer.getLength());
      buffer.getSelect().resetContent();
      
      buffer.getHistoric().ajouterMemento(buffer.sauverDansMemento(), buffer.getIndex());
      buffer.setIndex(buffer.getHistoric().getTailleMemento());
      
      buffer.memoire();
      buffer.actualiser();
      
    }else if(buffer.getLength() > 0){
      
      var sub1:String = buffer.getContent().substring(0, buffer.getSelect().getDebut());
      var sub2:String = buffer.getContent().substring(buffer.getSelect().getFin(), buffer.getLength());
      buffer.setContent(sub1+sub2);
      buffer.getSelect().setDebut(sub1.length());
      buffer.getSelect().setFin(sub1.length());
      buffer.getSelect().resetContent();
      buffer.getHistoric().ajouterMemento(buffer.sauverDansMemento(), buffer.getIndex());
      buffer.setIndex(buffer.getHistoric().getTailleMemento());
      
      buffer.memoire();
      buffer.actualiser();
      
    }else{
      throw new IllegalArgumentException("Backspace : Nothing to erase!");
    }
  }
  /*def effacer(buffer:Buffer){
    if((buffer.getLength() > 0) && (buffer.getSelect().getDebut() == buffer.getSelect().getFin())){
      var sub1:String = buffer.getContent().substring(0, buffer.getSelect().getFin()-1);
      buffer.setContent(sub1);
      buffer.getSelect().setDebut(buffer.getLength());
      buffer.getSelect().setFin(buffer.getLength());
      buffer.getSelect().resetContent();
      
      buffer.getHistoric().ajouterMemento(buffer.sauverDansMemento(), buffer.getIndex());
      buffer.setIndex(buffer.getHistoric().getTailleMemento());
      
    }else if(buffer.getLength() > 0){
      
      var sub1:String = buffer.getContent().substring(0, buffer.getSelect().getDebut());
      var sub2:String = buffer.getContent().substring(buffer.getSelect().getFin(), buffer.getLength());
      buffer.setContent(sub1+sub2);
      buffer.getSelect().setDebut(sub1.length());
      buffer.getSelect().setFin(sub1.length());
      buffer.getSelect().resetContent();
      buffer.getHistoric().ajouterMemento(buffer.sauverDansMemento(), buffer.getIndex());
      buffer.setIndex(buffer.getHistoric().getTailleMemento());
      
    }else{
      throw new IllegalArgumentException("Backspace : Nothing to erase!");
    }
  }*/
}