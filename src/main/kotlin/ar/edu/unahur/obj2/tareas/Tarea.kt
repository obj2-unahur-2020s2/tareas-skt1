package ar.edu.unahur.obj2.tareas

class Tarea (val horasEstimadas: Int, var responsable: Empleado,
             var empleadosAsignados: List<Empleado>, var costoInfraestructura: Int){

    fun nominaDeEmpleados() = empleadosAsignados + responsable

    fun horasNecesariasParaFinalizar() = horasEstimadas / empleadosAsignados.size
    fun sumaDeSalarioDeEmpleados() = empleadosAsignados.sumBy { it.sueldoPorHora * this.horasNecesariasParaFinalizar()}
    fun salarioDeResponsable() = responsable.sueldoPorHora * horasEstimadas

    fun costoDeTarea() = this.sumaDeSalarioDeEmpleados() + this.salarioDeResponsable() + costoInfraestructura


}

class TareaDeIntegración(val tareasACoordinar: List<Tarea>, var responsable: Empleado){
    fun sumaDeHorasDeSubtareas() = tareasACoordinar.sumBy { it.horasNecesariasParaFinalizar() }
    fun calculoDeHorasDePlanificacion() = this.sumaDeHorasDeSubtareas() / 8

    fun horasNecesariasParaTerminar() = this.sumaDeHorasDeSubtareas() + this.calculoDeHorasDePlanificacion()

    fun sumaDeCostosDeSubtareas() = tareasACoordinar.sumBy { it.costoDeTarea() }
    fun sueldoDeResponsable() = this.sumaDeCostosDeSubtareas() * 0.03

    fun costoDeTarea() = this.sumaDeCostosDeSubtareas() + this.sueldoDeResponsable()

    fun nominasDeSubtareas() = tareasACoordinar.map { it.nominaDeEmpleados() }

    fun nominaDeTarea() = this.nominasDeSubtareas() + responsable
}

class Empleado (val sueldoPorHora: Int) {}
