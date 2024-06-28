import Business.Business;
import LinkedList.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TablaHash tablaHash = new TablaHash();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);// use comma as separator
                String name = bussines[1];
                String address = bussines[2];
                String city = bussines[3];
                String state = bussines[4];
                Business objBusiness = new Business(name,address,city,state);
                tablaHash.insercion(bussines[0],objBusiness);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("<----------------------- BIENVENIDO -------------------------------->");

        do{
            System.out.print("INGRESE EL ID DE DICHO ELEMENTO: ");
            String id = entrada.nextLine();

            System.out.print("INGRESE EL NOMBRE: ");
            String nombre = entrada.nextLine();

            System.out.print("INGRESE LA DIRECCION: ");
            String direccion = entrada.nextLine();

            Node nodo = tablaHash.busqueda(id,nombre, direccion);

            //tablaHash.busqueda("7BPPs1Jzx8hMBDgMJYpwfQ","Plaza Vazquez", "1642 W High St");
            if(nodo == null){
                System.out.println("No existe dicho elemento");
            }

            else{
                System.out.println("Datos de ese objeto: " + "\n" + "Nombre: " + nodo.getObjBusiness().getName() + "\n" + "Dirección:" + nodo.getObjBusiness().getAddress()
                        + "\n" +  "Ciudad: " + nodo.getObjBusiness().getCity() + "\n" +  "Estado: " + nodo.getObjBusiness().getState() );
            }

            System.out.println("¿DESEA SEGUIR BUSCANDO DICHOS ELEMENTOS? 1.Si 2.No");
            opcion = entrada.nextInt();

            entrada.nextLine();

        }while(opcion != 2);



    }
}
