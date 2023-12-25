package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    @Override
    public void run() {
        String massageFromClient;

        while (socket.isConnected()) {
            try {
                massageFromClient = bufferedReader.readLine();

                broadcastMessage(massageFromClient);
            }
            catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message){
        for (ClientManager client: clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            }
            catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }
//    private void broadcastMessage(String message) {
//        if (message.startsWith("@")) {
//            int recipientSeparatorIndex = message.indexOf(":");
//            if (recipientSeparatorIndex != -1) {
//                String recipientName = message.substring(1, recipientSeparatorIndex).trim();
//                String privateMessage = message.substring(recipientSeparatorIndex + 1).trim();
//
//                for (ClientManager client : clients) {
//                    if (client.name.equals(recipientName)) {
//                        try {
//                            client.bufferedWriter.write("Личное от " + name + ": " + privateMessage);
//                            client.bufferedWriter.newLine();
//                            client.bufferedWriter.flush();
//                            System.out.println("Личное сообщение для " + recipientName + " отправлено.");
//                        } catch (IOException e) {
//                            closeEverything(socket, bufferedReader, bufferedWriter);
//                            System.err.println("Ошибка при отправке личного сообщения.");
//                            e.printStackTrace();
//                        }
//                        return;
//                    }
//                }
//                System.out.println("Клиент с именем " + recipientName + " не найден.");
//            } else {
//                System.out.println("Неверный формат личного сообщения. Используйте символ ':' для разделения имени и текста.");
//            }
//        } else {
//            // Общее сообщение
//            for (ClientManager client : clients) {
//                try {
//                    if (!client.name.equals(name)) {
//                        client.bufferedWriter.write("Общее от " + name + ": " + message);
//                        client.bufferedWriter.newLine();
//                        client.bufferedWriter.flush();
//                        System.out.println("Общее сообщение отправлено.");
//                    }
//                } catch (IOException e) {
//                    closeEverything(socket, bufferedReader, bufferedWriter);
//                    System.err.println("Ошибка при отправке общего сообщения.");
//                    e.printStackTrace();
//                }
//            }
//        }
//    }




    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {

        removeClient();
        try {

            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient(){
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

}
