

class Selectionner{
  var content : String="";
  var debut:Int=0;
  var fin:Int=0;
 
  def selectionner(d:Int,f:Int,b:Buffer){
    debut=d;
    fin=f;
    
    if(debut>fin){
      throw new IllegalArgumentException("T'as fait du boudin avec les chiffres");
    }
    if(debut<0){
      debut = 0;
      System.out.println(debut);
    }else if(debut>b.getContent().length()){
      debut = b.getContent().length();
    }
    if(fin>b.getContent().length()){
      fin = b.getContent().length();
    }else if(fin<0){
      fin = 0;
    }

    content=b.getContent().substring(debut,fin);
  }
  
  def resetContent()={
    content="";
  }
  def getContent()={
    content;
  }
  
  def getDebut()={
    debut;
  }
  
  def setDebut(d:Int)={
    debut = d;
  }
  
  def getFin()={
    fin;
  }
  
  def setFin(f:Int)={
    fin = f;
  }
  
}