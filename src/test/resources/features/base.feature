#autor Rogelio Navarro
  #language: es

  @HistoriaDeUsuario
  Característica: Verificar generacion PDF tarifario
    Yo como usuario quiero ver informacion sobre las tarifas de cuentas de deposito

  @Caso
  Escenario: Verificar PDF tarifas de cuentas de deposito
    Dado que el usuario ingresa a la pagina
    Cuando ingresa a la seccion Tarifarios
    Y selecciona ver el PDF de Tarifas de Cuentas de Deposito
    Entonces ve la informacion y verifica que el PDF sea el correcto