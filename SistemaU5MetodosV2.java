import java.util.Scanner;
import java.util.Date;
   public class SistemaU5MetodosV2{
   static int contC=0;
   public static void main(String args[]){
   int limite = 30;
   int opc=0, modificacion=0, auxC=0, aux2=0, auxBurbuja=0, auxModificacion=0, eliminar=0, auxEliminar=0, respE=0;
   int auxBusqueda=0;
   boolean flag=true;
   int claves[] = new int[limite];
   //Arreglos paralelos para almacenar los datos
   String nombres[] = new String[limite], departamento[] = new String[limite], fechaIng[] = new String[limite];
   String nuevoNombre = null, nuevoDepartamento = null, nuevoFechaIng = null;
   char nuevoSexo = 'n';
   float nuevoSalario = 0;
   char sexoChar[] = new char[limite];
   float salario[] = new float[limite]; 
   
      do{//principal
       
        opc = menus(opc, flag, claves);

         if(opc==1){//Opc=1 ----------------------------->ALTA DE EMPLEADOS<-------------------------------------
             //////////////////////////////////////Metodo opc 1////////////////////////////////////////////////              
               opcion1(auxC, claves, nombres, sexoChar, departamento, fechaIng, salario, flag);       
         }//Fin de Opc 1, alta de empleados  
         else
             if(opc==2){//Opc=2-------------------------------->Consulta individual<-------------------------------------------
             //////////////////////////////////////Metodo opc 2////////////////////////////////////////////////              
               opcion2(aux2, flag, claves, auxBusqueda, nombres, sexoChar, departamento, fechaIng, salario);
             }//Fin de opc 2, Consulta Individual 
             else
               if(opc==3){//Opc=2------------------------------->Consulta General<-------------------------------------------
             //////////////////////////////////////Metodo opc 3////////////////////////////////////////////////              
                  opcion3(claves, auxBurbuja, nombres, departamento, salario);
	            }//fin opc3, Consulta General
	            else
                 if(opc==4){//Opc=2---------------------------->Modificaciones<-----------------------------------------------
             //////////////////////////////////////Metodo opc 4////////////////////////////////////////////////              
                  opcion4(flag, auxModificacion, claves, nombres, sexoChar, auxBusqueda, departamento, fechaIng, salario, modificacion, nuevoNombre, nuevoSexo, nuevoDepartamento, nuevoFechaIng, nuevoSalario);
	              }//fin opc 4, Modificaciones
                 else
	                if(opc==5){//Opc=5-------------------------->Bajas<-------------------------------------------------------
             //////////////////////////////////////Metodo opc 5////////////////////////////////////////////////              
                     opcion5(flag, auxEliminar, auxBusqueda, claves, nombres, sexoChar, departamento, fechaIng, salario, eliminar, respE);             
                   }//fin opc5, Eliminacion y desplazamiento

            }while(opc >0 && opc <6);//Condicion y cierre del DoWhile
                     opcion6();

                  
   }//Main 
     /////////////////////////////////////////////////Menús//////////////////////////////////////////////////////////////////
    static int menus(int opc, boolean flag, int claves[]){
      Scanner leer=new Scanner(System.in);
      
      flag=true;
      if(contC==0){///////////////////////////////Menu de la posicion 0/////////////////////////////////////////////////////
         System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
         System.out.println("	Base de datos del H. Ayuntamiento de San Pedro de Los Aguaros.\n");
         System.out.println("AVISO: Aun no se ha ingresado ningun registro");
         System.out.println("¿Desea ingresar uno nuevo?\n");
         System.out.println("1) Si, realizar el primer registro.");
         System.out.println("6) No, finalizar sistema.");
         System.out.print("Opcion: ");
         opc=leer.nextInt();
         System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
         if(opc == 2 || opc == 3 || opc == 4 || opc == 5)
            opc = 6; 
      }//Finaliza el menu de la posicion 0 
  
   else{/////////////////////////////////////Menu para las demas claves//////////////////////////////////////////////////
      System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
      System.out.println("	Base de datos del H. Ayuntamiento de San Pedro de Los Aguaros.\n");
      System.out.println("Menu de opciones: \n");
      if(contC != claves.length)
         System.out.println("1) Alta");
         System.out.println("2) Consulta individual");
         System.out.println("3) Consulta general");
         System.out.println("4) Modificacion");
         System.out.println("5) Baja");
         System.out.println("6) Finalizar");
         System.out.println("Ingrese una opcion [1-6]");
         System.out.print("Opcion: ");
         opc=leer.nextInt();
         System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
      }//fin else menu para las demas claves
      return opc;
  }//Fin metodo para menús

               
     /////////////////////////////////////////////////Metodo opcion1/////////////////////////////////////////////////////////
               
               static void opcion1(int auxC, int claves[], String nombres[], char sexoChar[], String departamento[], String fechaIng[], float salario[], boolean flag){
               Scanner leer = new Scanner(System.in);
               
            System.out.println("Nuevo registro de empleado\n");
            System.out.println("Ingrese su clave: ");
            auxC=leer.nextInt();
            leer.nextLine();//limpiando buffer
            
            if(!validaRango(auxC, flag)){
            
            System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
               System.out.println("	¡CLAVE NO VALIDA!");
               System.out.println(" La clave " + auxC + " No entra dentro del rango establecido[100-200]");
               flag=false;

            
            }//rango no 100-200
            else{//si
            //if(validaRango(auxC, flag)){//////////
            contC++;
              if(contC==1){
               System.out.println("**Por favor, proporcione los datos solicitados a continuacion:**\n");
               claves[0]=auxC;
               System.out.print("Nombre: ");
               nombres[0]=leer.nextLine();
                  System.out.println("[Masculino -> M]");
                  System.out.println("[Femenino -> F]");
               System.out.print("Sexo: ");
               sexoChar[0]=leer.next().charAt(0);
               leer.nextLine();//Limpiando Buffer
               System.out.print("Departamento: ");
               departamento[0]=leer.nextLine();
               System.out.print("Fecha de ingreso: ");
               fechaIng[0]=leer.nextLine();
               System.out.print("Salario quincenal: $");
               salario[0]=leer.nextFloat();
               System.out.println("\n");
            }
            }
            if(contC>1){
            
               if(!validaClavesRepetidas(auxC, flag, claves)){
               
                  System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
                     System.out.println("	¡Error!");
                     System.out.println("	La clave ingresada ya ha sido registrada");
                     contC--;

                  }
            	else
               if(flag==true){
                  contC--;
                  System.out.println("\n**Por favor, proporcione los datos solicitados a continuacion:**");
                  claves[contC]=auxC;
                  System.out.print("Nombre: ");
                  nombres[contC]=leer.nextLine();
                     System.out.println("Sexo: [Masculino -> M]");
                     System.out.println("      [Femenino -> F]");
                  System.out.print("Sexo: ");
                  sexoChar[contC]=leer.next().charAt(0);
                  leer.nextLine();//Limpiando Buffer
                  System.out.print("Departamento: ");
                  departamento[contC]=leer.nextLine();
                  System.out.print("Fecha de ingreso: ");
                  fechaIng[contC]=leer.nextLine();
                  System.out.print("Salario quincenal: $");
                  salario[contC]=leer.nextFloat();
                  System.out.println("\n");
                  contC++;
                  }//fin if para llenar datos de las clave
                	}
                  }//--->Finaliza alta de empleados 
                  
 //////////////////////////////////////////Metodo opcion 2//////////////////////////////////////////////////////////////                 
               static void opcion2(int aux2, boolean flag, int claves[], int auxBusqueda, String nombres[], char sexoChar[], String departamento[], String fechaIng[], float salario[]){
                  Scanner leer = new Scanner(System.in);
                  
                  System.out.print("\n\nIngrese la clave del registro que desea consultar: ");
                  aux2 = leer.nextInt();
                  if(validaRango(aux2, flag)){
                                        
                     flag=true;
                     
                     if(flag==true)
                  for(int x=0; x<claves.length; x++){
                     if(aux2 == claves[x]){
                        flag=true;
                        auxBusqueda=x;
                        break;
                  	}
                     
                     else
                        flag=false;
                     }
                        if(flag == true){

                           System.out.printf("Clave: %d\n", claves[auxBusqueda]);
                           System.out.printf("Nombre: %s\n", nombres[auxBusqueda]);

                           if(sexoChar[auxBusqueda]=='m' || sexoChar[auxBusqueda]=='M')
                              System.out.println("Sexo: Masculino");
                           else
                              System.out.println("Sexo: Femenino");
                              System.out.printf("Departamento: %s\n", departamento[auxBusqueda]);
                              System.out.printf("Fecha de ingreso: %s\n", fechaIng[auxBusqueda]);
                              System.out.printf("Salario quincenal: $%.2f\n", salario[auxBusqueda]);
                         
                         }//Fin bandera para mostrar la consulta válida
                     else
                        if(flag==false){
                           System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
                           System.out.println("	¡Error!");
                           System.out.println("	No se encuentra ningun usuario registrado con esa clave\n");
                        }//Fin else, flag false
                      }//Fin flag true rango 100-200
                      else{
                      System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
                      System.out.println("	¡CLAVE NO VALIDA!");
                      System.out.println(" La clave " + aux2 + " No entra dentro del rango establecido[100-200]");
                      }
                }//Metodo opcion2
                
 //////////////////////////////////////////Metodo opcion 3//////////////////////////////////////////////////////////////                 
               static void opcion3(int claves[], int auxBurbuja, String nombres[], String departamento[], float salario[]){
                  for(int i=0; i<contC-1; i++){
                   for(int x=0; x<contC-1; x++){
                     if(claves[x] > claves[x+1]){
                        auxBurbuja = claves[x];
                        claves[x] = claves[x+1];
                        claves[x+1] = auxBurbuja;
                     }
                   }
                 }
                  
                     System.out.printf("|Clave|     Nombre    |Departamento|Salario|\n");
                  for(int x=0; x<contC; x++){
                     System.out.printf("|%5d|%15s|%12s|%7.2f|\n", claves[x], nombres[x], departamento[x], salario[x]);
                     }//Fin for para Consulta general
               }//Fin metodo opcion 3 
               
 //////////////////////////////////////////Metodo opcion 4//////////////////////////////////////////////////////////////                 
            static void opcion4(boolean flag, int auxModificacion, int claves[], String nombres[], char sexoChar[], int auxBusqueda, String departamento[], String fechaIng[], float salario[], int modificacion, String nuevoNombre, char nuevoSexo, String nuevoDepartamento, String nuevoFechaIng, float nuevoSalario){
               
               Scanner leer = new Scanner(System.in); 
               flag=false;
                     System.out.print("Ingrese la Clave del empleado que desea modificar: ");
                     auxModificacion = leer.nextInt();
                     if (validaRango(auxModificacion, flag)){//valores en rango no establecido
                     for(int x=0; x<contC; x++){
                        if(auxModificacion == claves[x]){
                           flag = true;
                           auxModificacion = x;
                           break;
                     	}
                        else
                           flag=false;
                        }
               	if (flag==false){
	                  System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
                     System.out.println("	¡Error!");
                     System.out.println("	La clave aun no ha sido registrada");
                  }
               	

                  if(flag==true){
                     do{//opc
                     System.out.printf("~~~~~~~~~~Clave: %d~~~~~~~~~~\n", claves[auxModificacion]);
                     System.out.printf("1) Nombre: %s\n", nombres[auxModificacion]);
                     if(sexoChar[auxBusqueda]=='m' || sexoChar[auxModificacion]=='M')
                        System.out.print("2) Sexo: Masculino\n");
                     else
                        System.out.print("2) Sexo: Femenino\n");
                     System.out.printf("3) Departamento: %s\n", departamento[auxModificacion]);
                     System.out.printf("4) Fecha de ingreso: %s\n", fechaIng[auxModificacion]);
                     System.out.printf("5) Salario quincenal: $%.2f\n", salario[auxModificacion]);
                     System.out.println("6) Volver al menu");
                     System.out.print("Seleccione la opcion del dato que desea modificar [1-6]: ");
                     modificacion = leer.nextInt();
	                  System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                     if(modificacion == 1){
                        leer.nextLine();//Limpiando Buffer
                        System.out.print("Ingrese el nuevo nombre: ");
                        nuevoNombre = leer.nextLine();
                        nombres[auxModificacion] = nuevoNombre;
                    	}
                     else
                        if(modificacion == 2){
                           leer.nextLine();//Limpiando Buffer
                              System.out.print("Ingrese el nuevo sexo [M=Masculino - F=Femenino]: ");
                              nuevoSexo = leer.next().charAt(0);
                              sexoChar[auxModificacion] = nuevoSexo;
                       	}
                     else
                        if(modificacion == 3){
                           leer.nextLine();//Limpiando Buffer
                           System.out.print("Ingrese el nuevo departamento: ");
                           nuevoDepartamento = leer.nextLine();
                           departamento[auxModificacion] = nuevoDepartamento;
                     	}
                     else
                        if(modificacion == 4){
                           leer.nextLine();//Limpiando Buffer
                           System.out.print("Ingrese la nueva fecha de ingreso: ");
                           nuevoFechaIng = leer.nextLine();
                           fechaIng[auxModificacion] = nuevoFechaIng;
                     	}
                     else
                        if(modificacion == 5){
                           System.out.print("Ingrese el nuevo salario: $");
                           nuevoSalario = leer.nextFloat();
                           salario[auxModificacion] = nuevoSalario;
                     	}
              	}while(modificacion > 0 && modificacion < 6);
	            }  
               }//Fin valores permitidos, 100-200
               else{
               System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
               System.out.println("	¡CLAVE NO VALIDA!");
               System.out.println(" La clave " + auxModificacion + " No entra dentro del rango establecido[100-200]");
               }
            }//Fin metodo opc 4
            
            static void opcion5(boolean flag, int auxEliminar, int auxBusqueda, int claves[], String nombres[], char sexoChar[], String departamento[], String fechaIng[], float salario[], int eliminar, int respE){
               Scanner leer = new Scanner(System.in);
               
                     flag=false;
                     System.out.print("Ingrese la Clave del empleado que desea eliminar: ");
                     auxEliminar = leer.nextInt();
                     if (validaRango(auxEliminar, flag)){
                        for(int x=0; x<contC; x++){
                           if(auxEliminar == claves[x]){
                              flag = true;
                              auxEliminar = x;
                              break;
                   	}
                     else
                        flag = false;
                     }
	               if(flag==false){
	                  System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
                     System.out.println("	¡Error!");
                     System.out.println("	La clave aun no ha sido registrada");
               	}
                 
	               if(flag==true){
                  System.out.printf("~~~~~~~~Eliminar empleado: %d~~~~~~~~\n", claves[auxEliminar]);
                  System.out.printf("Nombre: %s\n", nombres[auxEliminar]);
                  if(sexoChar[auxBusqueda]=='m' || sexoChar[auxEliminar]=='M')
                     System.out.print("Sexo: Masculino\n");
                  else
                     System.out.print("Sexo: Femenino\n");
                  System.out.printf("Departamento: %s\n", departamento[auxEliminar]);
                  System.out.printf("Fecha de ingreso: %s\n", fechaIng[auxEliminar]);
                  System.out.printf("Salario quincenal: $%.2f\n", salario[auxEliminar]);
                  System.out.print("¿Eliminar registro del empleado? [1=Si, 2=No]: ");
                  eliminar = leer.nextInt();
               	System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

               if(eliminar == 1){
                  System.out.print("¿Esta seguro de que desea borrar permanentemente el registro del usuario? [1=Si, 2=No]: ");
                  respE=leer.nextInt();
                  if(respE == 1){
                  
                     claves[auxEliminar] = 0;
                     nombres[auxEliminar] = null;
                     sexoChar[auxEliminar] = 0;
                     departamento[auxEliminar] = null;
                     fechaIng[auxEliminar] = null;
                     salario[auxEliminar] = 0;
                     
                     for (int x=auxEliminar; x<contC-1; x++){
                     //Borrar clave
                   claves[x] = claves[x+1];
                     //Borrar nombre
                   nombres[x] = nombres[x+1];
                     //Borrar sexo
                   sexoChar[x] = sexoChar[x+1];
                     //Borrar departamento
                   departamento[x] = departamento[x+1];
                     //Borrar Fecha
                   fechaIng[x] = fechaIng[x+1];
                   //Borrar salario
                   salario[x] = salario[x+1];
                               
                   flag=true;
	               }
                  if(flag=true)
                     contC--;
	            }
                  else{
                  //break;
               	}

              }
              }//flag true
              }//fin if rango 100-200
              else{
              System.out.println("*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*");
              System.out.println("	¡CLAVE NO VALIDA!");
              System.out.println(" La clave " + auxEliminar + " No entra dentro del rango establecido[100-200]");
              }

        }//Fin metodo opc 5
        
        
        static void opcion6 (){
        Date objDate = new Date();
        System.out.print("\nAutores:\n Brian Osvaldo Vega Rodriguez \n Yadira Camacho \n Kenia Mancilla \n");
        System.out.print(objDate.toString());      
        System.out.print("\n\nUnidad 4: 'Arreglos paralelos'");
        
        }//Fin metodo opc6
        
        
        static boolean validaRango(int auxC, boolean flag){
         if(auxC<100 || auxC>200){//valores en rango no establecido
            flag=false;
            }
         else
            flag=true;
            
            return flag;
          }//Fin metodo para validar rangos establecidos
          
      static boolean validaClavesRepetidas(int auxC, boolean flag, int claves[]){    
         for(int x=0; x<contC-1; x++)
            if(auxC==claves[x]){
               flag=false;
               break;
            }
            else
               flag=true;
               
            return flag;
     }//Fin metodo para buscar claves que ya fueron ingresadas en la opc1 (Alta)
}//class 
