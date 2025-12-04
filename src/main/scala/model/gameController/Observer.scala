package model.gameController

trait Observer {
  def update(message: Boolean): Unit
}
