

class Macro extends Commande{
  var commandList:List[Commande] = Nil;
  def ajout(c:Commande){
    commandList=commandList:+c;
  }

  override def execute(){
    commandList.foreach{
      c => c.execute();
    }
  }
}