

class Historique(){

    var liste:List[Memento] = Nil;
    
    def getTailleMemento()={
        liste.length-1;
    }
    
    /**
     * Ajouter un "Memento" à la liste
     * @param pMemento
     */
    def ajouterMemento(pMemento:Memento, id:Int) {
      if(id < (liste.length-1)){
        //System.out.println(id);
        var i:Int = 0;
        for(i <- 1 to (getTailleMemento()-id-1)){
          //System.out.println("tr "+i+" "+liste.length);
          liste = liste.init;
        }
        liste = liste:+pMemento;
      }else{
        liste = liste:+pMemento;
      }
    }
    
    /**
     * Retourne le "Memento" correspondant à l'index
     * @param pIndex
     * @return
     */
    def getMemento(pIndex:Int)={
        liste(pIndex);
    }
}