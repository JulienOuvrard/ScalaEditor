package org.alma.gl

object Main {
  def main(args:Array[String]) {
    val buffer1 = new Buffer();
    val buffer2 = new Buffer();
    
    val ut1 = new Utilisateur("Blu");
    val ut2 = new Utilisateur("Bla");
    
    ut1.abonnement(buffer1);
    ut1.abonnement(buffer2);
    ut2.abonnement(buffer1);
    
    buffer1.write("Il était une fois, un canard qui fait coin-coin!");
    buffer1.backspace();
    buffer1.undo();
    buffer1.selection(13,3);
    buffer1.cut();
    //println(buffer1.getCb());
    buffer1.cursor(0);
    buffer1.paste();
    buffer1.undo();
    buffer1.redo();
    buffer1.cursor(75);
    buffer1.paste();
    
    buffer1.write("La poule fait cot-cot.");
    buffer1.selection(28, 42);
    buffer1.copy();
    buffer1.cursor(1000);
    buffer1.paste();
    buffer1.undo();
    buffer1.undo();
    
    buffer1.selection(48,58);
    buffer1.backspace();
    buffer1.write("& ");
    
    buffer1.selection(19, 29);
    buffer1.copy();
    buffer1.selection(48, 64);
    buffer1.paste();
    
    ut2.desabonnement(buffer1);
    
    //buffer1.redo();
    System.out.println("**************************************************************");
    var i:Int = 0;
    for(i <- 1 to 12){
      buffer1.undo();
    }
    System.out.println("**************************************************************");
    
    val mc = new Macro();
    mc.ajouterCommande(new Ecrire(buffer2,"blabla!"));
    mc.ajouterCommande(new Effacer(buffer2));
    mc.executer();
  }
}