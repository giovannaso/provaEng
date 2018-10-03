import akka.actor._
import akka.routing.RoundRobinRouter
import scala.io._
import java.io._
import java.io.FileReader
import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList
import java.util.Scanner
import scala.collection.JavaConverters._



sealed trait Message

case class User() extends Message
case class Start() extends Message
case class Tempo() extends Message
case class Info() extends Message


class Libraries extends Actor{
     def receive: Receive = {
            case User() => {
                println("entrou user")
                val source = Source.fromFile("pimpar")
                val us1 = new PrintWriter("user1.txt")
                val us2 = new PrintWriter("user2.txt")
                val us3 = new PrintWriter("user3.txt")
                val us4 = new PrintWriter("user4.txt")
                val us5 = new PrintWriter("user5.txt")
                val us6 = new PrintWriter("user6.txt")
                val us7 = new PrintWriter("user7.txt")
                val us8 = new PrintWriter("user8.txt")
                for(line <- Source.fromFile("pimpar").getLines) {
                    if (line.startsWith("java")) {
                        us1.write(line + "\n")
                        } 
                        else {
                            if (line.startsWith("root")) {
                                us2.write(line + "\n")
                            } 
                            else {
                                if (line.startsWith("apache")) {
                                    us3.write(line + "\n")
                                } 
                                else {
                                    if (line.startsWith("stack")) {
                                        us4.write(line + "\n")
                                    } 
                                    else {
                                        if (line.startsWith("postgres")) {
                                            us5.write(line + "\n")
                                        } 
                                        else {
                                            if (line.startsWith("ubuntu")) {
                                                us6.write(line + "\n")
                                        } 
                                            else {
                                                if (line.startsWith("docker")) {
                                                    us7.write(line + "\n")
                                            }
                                                else{
                                                    us8.write(line + "\n")
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                }
                source.close()
                us1.close()
                us2.close()
                us3.close()
                us4.close()
                us5.close()
                us6.close()
                us7.close()
                us8.close()
                println("saiu user")
            }
        case Tempo() => {
            println("entrou tempo")
            val a1 = new PrintWriter("aux.txt")
                val mt = new PrintWriter("mediaTempo.txt")
                var lTempo = ArrayBuffer[String]()
                var lCpu = ArrayBuffer[String]()
                var lMemoria = ArrayBuffer[String]()
 
               for(line <- Source.fromFile("pimpar").getLines) {
                        a1.write(line + " ")
                }
          
               val scanner: Scanner = new Scanner(new FileReader("aux.txt"))
                       .useDelimiter(" ");
                       
                while(scanner.hasNextLine()) {
                 val user: String = scanner.next();
                 val pid: String = scanner.next();
                 val cpu: String = scanner.next();
                 val memoria: String = scanner.next();
                 val tempo: String  = scanner.next();
                 
                 
               lTempo += tempo
               lCpu += cpu
               lMemoria += memoria
              }
              
            var sum: Int = 0
            var i: Int = 0
            while (i < lCpu.length) {
            sum += lCpu(i).toInt
            i += 1
            } 
        }
        case Info() => {
         val a1 = new PrintWriter("aux.txt")
                val b = new PrintWriter("userEPID.txt")

            for(line <- Source.fromFile("pimpar").getLines) {
                        a1.write(line + " ")
            }

               val scanner: Scanner = new Scanner(new FileReader("pimpar"))
                       .useDelimiter(" ");

                while(scanner.hasNextLine()) {
                  val user: String = scanner.next();
                  val pid: String = scanner.next();
                  val cpu: String = scanner.next();
                  val memoria: String = scanner.next();
                  val tempo: String = scanner.next();

                  b.write(user + " " + pid + "\n")
                  }
            }
        }
    }

class Master() extends Actor{
    
 val Library = context.actorOf(Props[Libraries].withRouter(RoundRobinRouter(8)), "Library")
  
    override def receive: Receive = {
        case Start => {
          Library ! User()
          Library ! Tempo()
          Library ! Info()
        }
    }                   
}

object Main{
    def main(args: Array[String]): Unit = {
        val system = ActorSystem("MasterSystem")
        val masterActor = system.actorOf(Props(new Master()),"masterActor")
        masterActor ! Start
    }
}