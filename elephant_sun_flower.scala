import scala.collection.mutable.ArrayBuffer 

class HomeDecorStore {
  private var products: ArrayBuffer[Product] = ArrayBuffer()

  def addProduct(product: Product): Unit = {
    products += product
  }

  def removeProduct(product: Product): Unit = {
    products -= product
  }

  def searchByName(name: String): ArrayBuffer[Product] = {
    products.filter(product => product.name == name)
  }

  def searchByPrice(price: Int): ArrayBuffer[Product] = {
    products.filter(product => product.price == price)
  }

  def searchByCategory(category: String): ArrayBuffer[Product] = {
    products.filter(product => product.category == category)
  }

  def searchByBrand(brand: String): ArrayBuffer[Product] = {
    products.filter(product => product.brand == brand)
  }

  def findProduct(id: Int): Product = {
    products.find(product => product.id == id).head
  }

  def getProducts(): ArrayBuffer[Product] = products

}

case class Product(id: Int, name: String, price: Int, category: String, brand: String)

object HomeDecorStore {
  def main(args: Array[String]): Unit = {
    val hds = new HomeDecorStore
    val prod1 = Product(1, "Vase", 35, "Decor", "Faber")
    val prod2 = Product(2, "Table Lamp", 50, "Lighting", "Faber")
    val prod3 = Product(3, "Painting", 100, "Decor", "Faber")
    hds.addProduct(prod1)
    hds.addProduct(prod2)
    hds.addProduct(prod3)
    println(hds.searchByName("Vase")) // ArrayBuffer(Vase (1), 35, Decor, Faber)
    println(hds.searchByPrice(50)) // ArrayBuffer(Table Lamp (2), 50, Lighting, Faber)
    println(hds.searchByCategory("Decor")) //ArrayBuffer(Vase (1), 35, Decor, Faber, Painting (3), 100, Decor, Faber)
    println(hds.searchByBrand("Faber")) // ArrayBuffer(Vase (1), 35, Decor, Faber, Table Lamp (2), 50, Lighting, Faber, Painting (3), 100, Decor, Faber)
    println(hds.findProduct(1)) // Product(1,Vase,35,Decor,Faber)
    println(hds.getProducts()) // ArrayBuffer(Vase (1), 35, Decor, Faber, Table Lamp (2), 50, Lighting, Faber, Painting (3), 100, Decor, Faber)
  }
}