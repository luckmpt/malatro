package model.gameController

trait Subject {
  private var observers: List[Observer] = List()
  
  def subscribe(observer: Observer): Unit = {
    observers = observer :: observers
  }
  
  def unsuscribe(observer: Observer): Unit = {
    observers = observers.filterNot(_ == observer)
  }
  
  def notifyObservers(message: Boolean): Unit = {
    observers.foreach(_.update(message))
  }

}
