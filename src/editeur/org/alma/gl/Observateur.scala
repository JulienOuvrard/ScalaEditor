package org.alma.gl
/**
 * Interface des observateurs
 */
trait Observateur {
  def actualiser(o:Observable, text:String);
  def printNom();
}