package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStream
{
    static boolean exit = false;

    public static void main(String[] args)
    {
        final int bindPort = 6666;
        boolean exit = false;

        try{
            ServerSocket serverSocket = new ServerSocket(bindPort);
            Socket server = serverSocket.accept();
            OutputStream os = server.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            while (!exit){
                System.out.println("Conexion recibida");
                InputStream is = server.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bf = new BufferedReader(isr);
                String linea = bf.readLine();
                if("1".equals(linea)){
                    insert(linea);
                }
                if("0".equals(linea)){
                    System.out.println("Cerrando el servidor de consultas...");
                    Thread.sleep(1000);
                    System.exit(0);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("va mal");
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

   static private void insert(String linea)
    {

    }
}
