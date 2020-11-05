package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
    // empleados
    var Juan = Empleado(200)
    var Pedro = Empleado(300)
    var Marcela = Empleado(100)
    var Laura = Empleado(400)
    var Carolina = Empleado(300)
    var Carlos = Empleado(500)
    var Veronica = Empleado(200)
    var BigBoss = Empleado(1000)

    // tareas
    var TareaUno = Tarea(30, Laura, listOf(Marcela, Carlos, Pedro, Juan, Veronica), 9000)
    var TareaDos = Tarea(24, Juan, listOf(Veronica, Laura, Carlos, Carolina), 8000)
    var TareaTres = Tarea(27, Veronica, listOf(Juan, Carolina, Pedro), 5000)

    // tarea integracion
    var TareaMadre = TareaDeIntegración(listOf(TareaUno, TareaTres), BigBoss)

    // requerimiento 1
    it("la nómina de la tarea uno es (Maercela, Carlos, Pedro, Juan, Veronica, Laura)"){
      var listaAux = listOf<Empleado>(Marcela, Carlos, Pedro, Juan, Veronica, Laura)
      TareaUno.nominaDeEmpleados().shouldContainAll(listaAux)
    }
    it("la nómina de la tarea tres es (Juan, Carolina, Pedro, Veronica)"){
      var listaAux = listOf<Empleado>(Juan, Carolina, Pedro, Veronica)
      TareaTres.nominaDeEmpleados().shouldContainAll(listaAux)
    }

    // requerimiento 2
    it("para la tarea tres se necesitan 9 horas"){
      TareaTres.horasNecesariasParaFinalizar().shouldBe(9)
    }
    it("para la tarea dos se necesitan 6 horas"){
      TareaDos.horasNecesariasParaFinalizar().shouldBe(6)
    }

    // requerimiento 3
    it("el costo de la tarea dos es de 21200"){
      TareaDos.costoDeTarea().shouldBe(21200)
    }
    it("el costo de la tarea uno es de 28800"){
      TareaUno.costoDeTarea().shouldBe(28800)
    }

    // requerimiento 4
    it("La tarea madre necesita 16 horas para realizarse"){
      TareaMadre.horasNecesariasParaTerminar().shouldBe(16)
    }
    it("El costo total de la tarea madre es de 47792"){
      TareaMadre.costoDeTarea().shouldBe(47792)
    }
    it("La nomina de la tarea madre es: (Marcela, Carlos, Pedro, Juan, Veronica, Laura), (Juan, Carolina, Pedro, Veronica), y BigBoss"){
      var listaAux = listOf(listOf(Marcela, Carlos, Pedro, Juan, Veronica, Laura),
                            listOf(Juan, Carolina, Pedro, Veronica),
                            BigBoss)
      TareaMadre.nominaDeTarea().shouldContainAll(listaAux)
    }
  }
})
